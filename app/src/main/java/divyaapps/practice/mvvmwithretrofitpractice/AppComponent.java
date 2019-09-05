package divyaapps.practice.mvvmwithretrofitpractice;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Divya Gupta on 05-Sep-19.
 **/
@Component(modules = {AppModule.class,UtilsModule.class})

@Singleton
public interface AppComponent {

    void doInjection(LoginActivity loginActivity);
}
