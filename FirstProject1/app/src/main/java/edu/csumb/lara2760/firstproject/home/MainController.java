package edu.csumb.lara2760.firstproject.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import javax.inject.Inject;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import edu.csumb.lara2760.firstproject.WeatherApp;
import edu.csumb.lara2760.firstproject.cityName.CityNameActivity;
import edu.csumb.lara2760.firstproject.network.components.NetComponent;
import edu.csumb.lara2760.firstproject.util.PerController;
import retrofit2.Retrofit;

/**
 * controller for {@link MainActivity}
 */
public class MainController implements MainLayout.MainLayoutListener {

    private MainActivity mMainActivity;

    @Inject MainLayout mMainLayout;
    @Inject Retrofit mRetrofit;

    public MainController(@NonNull MainActivity mainActivity) {
        mMainActivity = mainActivity;
        DaggerMainController_MainControllerComponent.builder()
                .netComponent(((WeatherApp) mMainActivity.getApplicationContext()).getNetComponent())
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
    @Component(dependencies = NetComponent.class, modules = MainControllerModule.class)
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
