package edu.csumb.lara2760.firstproject.home;

import edu.csumb.lara2760.firstproject.R;

/**
 * Layout for the {@link MainActivity}
 */

public class MainLayout {

    private MainActivity mMainActivity;
    
    public MainLayout(MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mMainActivity.setContentView(R.layout.activity_main);
    }
}
