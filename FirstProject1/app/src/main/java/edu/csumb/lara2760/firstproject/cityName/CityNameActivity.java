package edu.csumb.lara2760.firstproject.cityName;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CityNameActivity extends AppCompatActivity {

    private CityNameController mCityNameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCityNameController = new CityNameController(this);
    }
}
