package divyaapps.practice.mvvmwithretrofitpractice;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Divya Gupta on 05-Sep-19.
 **/
public class CustomProgressDialog {
    public static Dialog getProgressDialog(Context context, String message) {
        Dialog dialog = new Dialog(context);
        @SuppressLint("InflateParams")
        View customProgressDialogView = LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog, null);
        TextView tvMessage = customProgressDialogView.findViewById(R.id.progress_dialog_message);
        tvMessage.setText(message);

        dialog.setContentView(customProgressDialogView);
        if (dialog.getWindow() != null)
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);


        return dialog;
    }
}
