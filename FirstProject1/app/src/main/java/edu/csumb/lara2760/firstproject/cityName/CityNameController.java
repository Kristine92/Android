package edu.csumb.lara2760.firstproject.cityName;

/**
 * controller for {@link CityNameActivity}
 */
public class CityNameController {

    private CityNameActivity mCityNameActivity;
    private CityNameLayout mCityNameLayout;

    public CityNameController(CityNameActivity cityNameActivity){
        mCityNameActivity = cityNameActivity;
        mCityNameLayout = new CityNameLayout(mCityNameActivity);
    }
}
