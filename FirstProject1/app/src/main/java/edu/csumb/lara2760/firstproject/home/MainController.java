package edu.csumb.lara2760.firstproject.home;

/**
 *Controller for {@link MainActivity}
 */

public class MainController {

    private MainActivity mMainActivity;

    private MainLayout mMainLayout;
    public MainController(MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mMainLayout = new MainLayout(mMainActivity);
    }
}
