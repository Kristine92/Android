package edu.csumb.lara2760.firstproject.network.components;

import javax.inject.Singleton;
import dagger.Component;
import edu.csumb.lara2760.firstproject.network.module.AppModule;
import edu.csumb.lara2760.firstproject.network.module.NetModule;
import retrofit2.Retrofit;

/**
 *
 *Created a interface to implement retrofit
 */
@Singleton

@Component(modules = {AppModule.class, NetModule.class})

public interface NetComponent {
    Retrofit retrofit();
}
