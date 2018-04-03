package com.example.saba.sample_database_realm_mvp_dager.app;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import javax.inject.Inject;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingAndroidActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        Fresco.initialize(this);
    }

    private void initDagger(){
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return mDispatchingAndroidActivityInjector;
    }
}
