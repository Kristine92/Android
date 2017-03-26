package edu.csumb.lara2760.firstproject;

import android.app.Application;
import edu.csumb.lara2760.firstproject.network.components.DaggerNetComponent;
import edu.csumb.lara2760.firstproject.network.components.NetComponent;
import edu.csumb.lara2760.firstproject.network.module.AppModule;
import edu.csumb.lara2760.firstproject.network.module.NetModule;

/**
 * Build netComponents
 */

public class WeatherApp  extends Application{
    private NetComponent mNetComponent;
    @Override
    public void onCreate(){
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://api.openweathermap.org/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
