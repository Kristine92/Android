package edu.csumb.lara2760.firstproject.home;

import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.csumb.lara2760.firstproject.R;

/**
 * Layout for the {@link MainActivity}
 */

public class MainLayout {

    private MainActivity mMainActivity;
    @BindView(R.id.button_test) Button mButton;
    
    public MainLayout(@NonNull MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mMainActivity.setContentView(R.layout.activity_main);
        ButterKnife.bind(this, mMainActivity);
    }

    @OnClick(R.id.button_test)
    void onButtonTestClicked() {
        Toast.makeText(mMainActivity.getApplicationContext(), "TEST", Toast.LENGTH_SHORT).show();
    }
}
