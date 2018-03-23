package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import dagger.Module;
import dagger.Provides;


@Module
public class MainActivityModule {

    @Provides
    static MainPresenterImpl provideMainPresenter() {
        return new MainPresenterImpl();
    }

}
