package divyaapps.practice.mvvmwithretrofitpractice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by Divya Gupta on 05-Sep-19.
 **/
public class Utils {
    public static String toPrettyFormat(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(jsonString);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(json);
    }
}
