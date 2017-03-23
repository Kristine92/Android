package edu.csumb.lara2760.firstproject.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import edu.csumb.lara2760.firstproject.cityName.CityNameActivity;

/**
 * controller for {@link MainActivity}
 */
public class MainController implements MainLayout.MainLayoutListener {

    private MainActivity mMainActivity;
    private MainLayout mMainLayout;

    public MainController(@NonNull MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mMainLayout = new MainLayout(mMainActivity, this);
    }

    @Override
    public void onButtonTestClicked() {
        Intent intent = new Intent(mMainActivity, CityNameActivity.class);
        mMainActivity.startActivity(intent);
    }
}
