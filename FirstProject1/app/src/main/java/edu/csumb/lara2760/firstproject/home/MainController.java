package edu.csumb.lara2760.firstproject.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import javax.inject.Inject;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import edu.csumb.lara2760.firstproject.cityName.CityNameActivity;
import edu.csumb.lara2760.firstproject.util.PerController;

/**
 * controller for {@link MainActivity}
 */
public class MainController implements MainLayout.MainLayoutListener {

    private MainActivity mMainActivity;

    @Inject MainLayout mMainLayout;

    public MainController(@NonNull MainActivity mainActivity) {
        mMainActivity = mainActivity;
        DaggerMainController_MainControllerComponent
                .builder()
                .mainControllerModule(new MainControllerModule(mMainActivity, this))
                .build()
                .inject(this);
    }

    @Override
    public void onButtonTestClicked() {
        Intent intent = new Intent(mMainActivity, CityNameActivity.class);
        mMainActivity.startActivity(intent);
    }
    @PerController
    @Component(modules = MainControllerModule.class)
    interface  MainControllerComponent{
        void inject (MainController mainController);
    }

    @Module
    static class MainControllerModule{
        private MainActivity mMainActivity;
        private MainLayout.MainLayoutListener mMainLayoutListener;
        public MainControllerModule(MainActivity activity, MainLayout.MainLayoutListener listener){
            mMainActivity = activity;
            mMainLayoutListener = listener;
        }
        @Provides
        @PerController
        MainLayout providesMainLayout(){
            return new MainLayout(mMainActivity, mMainLayoutListener);
        }
    }
}
