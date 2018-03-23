package com.example.saba.sample_database_realm_mvp_dager.app;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends DaggerApplication {


    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        AppComponent appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();

        appComponent.inject(this);

        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
