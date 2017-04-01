package edu.csumb.lara2760.firstproject.cityName;

import android.app.AlertDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import edu.csumb.lara2760.firstproject.R;
import edu.csumb.lara2760.firstproject.WeatherApp;
import edu.csumb.lara2760.firstproject.network.components.NetComponent;
import edu.csumb.lara2760.firstproject.util.PerController;
import edu.csumb.lara2760.firstproject.weatherApi.WeatherApi;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static edu.csumb.lara2760.firstproject.R.id.cityNameInput;

/**
 * controller for {@link CityNameActivity}
 */
public class CityNameController implements CityNameLayout.CityNameLayoutListener {

    private CityNameActivity mCityNameActivity;
    @Inject CityNameLayout mCityNameLayout;
    @Inject Retrofit mRetrofit;

    public CityNameController(CityNameActivity cityNameActivity){
        mCityNameActivity = cityNameActivity;
        DaggerCityNameController_CityNameControllerComponent.builder()
                .netComponent(((WeatherApp) cityNameActivity.getApplicationContext()).getNetComponent())
                .cityNameControllerModule(new CityNameControllerModule(mCityNameActivity, this))
                .build()
                .inject(this);

        mRetrofit.create(WeatherApi.class)
                .getWeather("9dd263d0405171a8127527ff014f258a", "Salinas")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mCityNameLayout);
    }

    @Override
    public void onSubmitButtonClicked(String cityName) {
        Toast.makeText(mCityNameActivity.getApplicationContext(), cityName, Toast.LENGTH_SHORT).show();
    }

    @PerController
    @Component(dependencies = NetComponent.class, modules = CityNameControllerModule.class)
    interface CityNameControllerComponent {
        void inject (CityNameController cityNameController);
    }

    @Module
    static class CityNameControllerModule {
        private CityNameActivity cityNameActivity;
        private CityNameLayout.CityNameLayoutListener mCityNameLayoutListener;
        public CityNameControllerModule(CityNameActivity activity, CityNameLayout.CityNameLayoutListener listener) {
            cityNameActivity = activity;
            mCityNameLayoutListener = listener;
        }

        @Provides

        @PerController
        CityNameLayout providesCityNameLayout() {
            return new CityNameLayout(cityNameActivity, mCityNameLayoutListener);
        }
    }

}
