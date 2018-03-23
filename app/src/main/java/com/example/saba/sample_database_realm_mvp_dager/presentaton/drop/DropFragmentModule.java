package com.example.saba.sample_database_realm_mvp_dager.presentaton.drop;


import dagger.Module;
import dagger.Provides;

@Module
public abstract class DropFragmentModule {

    @Provides
    static DropPresenterImpl provideDropFragmentPresenter() {
        return new DropPresenterImpl();
    }

}
