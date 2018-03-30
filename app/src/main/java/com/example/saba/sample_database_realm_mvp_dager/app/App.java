package com.example.saba.sample_database_realm_mvp_dager.app;

import android.app.Activity;
import android.app.Application;
import javax.inject.Inject;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingAndroidActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        initDagger();
    }

    private void initDagger(){
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return mDispatchingAndroidActivityInjector;
    }
}
