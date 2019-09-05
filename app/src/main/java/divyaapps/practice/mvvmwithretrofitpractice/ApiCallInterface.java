package divyaapps.practice.mvvmwithretrofitpractice;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Divya Gupta on 05-Sep-19.
 **/
public interface ApiCallInterface {

    @POST(Urls.LOGIN)
    Observable<JsonElement> login(@Body LoginRequest loginRequest);
}
