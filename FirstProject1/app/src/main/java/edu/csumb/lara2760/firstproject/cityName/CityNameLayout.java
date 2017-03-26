package edu.csumb.lara2760.firstproject.cityName;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import edu.csumb.lara2760.firstproject.R;
import edu.csumb.lara2760.firstproject.data.weatherData.Weather;
import rx.Subscriber;

/**
 * layout for {@link CityNameActivity}
 */
public class CityNameLayout extends Subscriber<Weather> {

    private CityNameActivity mCityNameActivity;

    @BindView(R.id.button_test) Button mButton;

    public CityNameLayout(CityNameActivity cityNameActivity){
        mCityNameActivity = cityNameActivity;
        mCityNameActivity.setContentView(R.layout.activity_city_name);
    }

    @Override
    public void onCompleted() { }

    @Override
    public void onError(Throwable e) {
        Log.d("ERROR: ", e.getMessage());

    }

    @Override
    public void onNext(Weather weather) {
        Toast.makeText(mCityNameActivity.getApplicationContext(), weather.getClouds().toString(), Toast.LENGTH_SHORT).show();
    }
}
