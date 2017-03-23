package edu.csumb.lara2760.firstproject.cityName;

import android.widget.Button;
import butterknife.BindView;
import edu.csumb.lara2760.firstproject.R;

/**
 * layout for {@link CityNameActivity}
 */
public class CityNameLayout {

    private CityNameActivity mCityNameActivity;

    @BindView(R.id.button_test) Button mButton;

    public CityNameLayout(CityNameActivity cityNameActivity){
        mCityNameActivity = cityNameActivity;
        mCityNameActivity.setContentView(R.layout.activity_city_name);
    }
}
