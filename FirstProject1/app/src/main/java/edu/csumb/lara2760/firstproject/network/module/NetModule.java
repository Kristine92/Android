package edu.csumb.lara2760.firstproject.network.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Creating modules for our application to use
 */
@Module
public class NetModule {
    String mBaseUrl;
    public NetModule(String baseurl) {
        mBaseUrl = baseurl;
    }

    @Provides
    @Singleton
    SharedPreferences provdesPreferencees(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache providesHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson providesGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
