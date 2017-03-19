package edu.csumb.lara2760.firstproject.home;

import android.support.annotation.NonNull;

/**
 *Controller for {@link MainActivity}
 */

public class MainController {

    private MainActivity mMainActivity;

    private MainLayout mMainLayout;
    public MainController(@NonNull MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mMainLayout = new MainLayout(mMainActivity);
    }
}
