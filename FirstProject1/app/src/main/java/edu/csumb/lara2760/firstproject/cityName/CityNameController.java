package edu.csumb.lara2760.firstproject.cityName;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import edu.csumb.lara2760.firstproject.WeatherApp;
import edu.csumb.lara2760.firstproject.network.components.NetComponent;
import edu.csumb.lara2760.firstproject.util.PerController;
import edu.csumb.lara2760.firstproject.weatherApi.WeatherApi;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * controller for {@link CityNameActivity}
 */
public class CityNameController {

    private CityNameActivity mCityNameActivity;
    @Inject CityNameLayout mCityNameLayout;
    @Inject Retrofit mRetrofit;

    public CityNameController(CityNameActivity cityNameActivity){
        mCityNameActivity = cityNameActivity;
        DaggerCityNameController_CityNameControllerComponent.builder()
                .netComponent(((WeatherApp) cityNameActivity.getApplicationContext()).getNetComponent())
                .cityNameControllerModule(new CityNameControllerModule(mCityNameActivity))
                .build()
                .inject(this);
        mRetrofit.create(WeatherApi.class)
                .getWeather("9dd263d0405171a8127527ff014f258a", "Salinas")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mCityNameLayout);
    }

    @PerController
    @Component(dependencies = NetComponent.class, modules = CityNameControllerModule.class)
    interface CityNameControllerComponent {
        void inject (CityNameController cityNameController);
    }
    @Module
    static class CityNameControllerModule {
        private CityNameActivity cityNameActivity;
        public CityNameControllerModule(CityNameActivity activity){
            cityNameActivity = activity;
        }
        @Provides
        @PerController
        CityNameLayout providesCityNameLayout(){
            return new CityNameLayout(cityNameActivity);
        }
    }

}
