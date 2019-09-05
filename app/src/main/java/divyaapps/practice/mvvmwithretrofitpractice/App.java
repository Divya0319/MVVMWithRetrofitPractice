package divyaapps.practice.mvvmwithretrofitpractice;

import android.app.Application;
import android.content.Context;

/**
 * Created by Divya Gupta on 05-Sep-19.
 **/
public class App extends Application {

    AppComponent appComponent;
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).utilsModule(new UtilsModule()).build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
