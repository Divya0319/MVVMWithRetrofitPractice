package divyaapps.practice.mvvmwithretrofitpractice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.JsonElement;

/**
 * Created by Divya Gupta on 05-Sep-19.
 **/
public class ApiResponse {
    private Status status;

    @Nullable
    private JsonElement data;

    @Nullable
    private Throwable error;

    public ApiResponse(Status status, @Nullable JsonElement data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }


    public Status getStatus() {
        return status;
    }

    @Nullable
    public JsonElement getData() {
        return data;
    }

    @Nullable
    public Throwable getError() {
        return error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(Status.LOADING, null, null);
    }

    public static ApiResponse success(@NonNull JsonElement data) {
        return new ApiResponse(Status.SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(Status.ERROR, null, error);
    }
}
