package divyaapps.practice.mvvmwithretrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    Gson gson;
    Dialog progressDialog;


    @BindView(R.id.tie_email)
    TextInputEditText tieEmail;

    @BindView(R.id.tie_password)
    TextInputEditText tiePassword;

    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = CustomProgressDialog.getProgressDialog(this, "Hang on for a sec");
        ButterKnife.bind(this);

        ((App) getApplication()).getAppComponent().doInjection(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);

        viewModel.loginResponse().observe(this, apiResponse -> consumeResponse(apiResponse));
    }

    private void consumeResponse(ApiResponse apiResponse) {
        switch (apiResponse.getStatus()) {
            case LOADING:
                progressDialog.show();
                break;

            case SUCCESS:
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                renderSuccessResponse(apiResponse.getData());
                break;
            case ERROR:
                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), apiResponse.getError().getMessage(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void renderSuccessResponse(JsonElement response) {
        if (!response.isJsonNull()) {
            String prettyJson = Utils.toPrettyFormat(response.toString());
            Log.d("--------", "--------------------------");
            Log.d("LoginResponse", prettyJson);
            Log.d("--------", "--------------------------");
            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.bt_sign_in)
    void onLoginButtonClicked() {
        if (isDataValid()) {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setEmail(tieEmail.getText().toString());
            loginRequest.setPassword(tiePassword.getText().toString());
            String requestString = Utils.toPrettyFormat(gson.toJson(loginRequest));
            Log.d("--------", "--------------------------");
            Log.d("LoginRequest", requestString);
            Log.d("--------", "--------------------------");
            viewModel.hitLoginApi(loginRequest);
        }
    }

    private boolean isDataValid() {
        if (tieEmail.getText().toString().trim().isEmpty()) {
            Toast.makeText(LoginActivity.this, "Enter valid email", Toast.LENGTH_LONG).show();
            return false;
        } else if (tiePassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter valid password", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
