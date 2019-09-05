package divyaapps.practice.mvvmwithretrofitpractice;

import com.google.gson.JsonElement;

import io.reactivex.Observable;

/**
 * Created by Divya Gupta on 05-Sep-19.
 **/
public class Repository {

    private ApiCallInterface apiCallInterface;

    public Repository(ApiCallInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }

    /*
     * method to call login api
     * */

    public Observable<JsonElement> executeLogin(LoginRequest loginRequest) {
        return apiCallInterface.login(loginRequest);
    }
}
