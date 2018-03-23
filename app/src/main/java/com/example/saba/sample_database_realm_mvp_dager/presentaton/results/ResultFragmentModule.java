package com.example.saba.sample_database_realm_mvp_dager.presentaton.results;


import dagger.Module;
import dagger.Provides;


@Module
public class ResultFragmentModule {

    @Provides
    static ResultFragmentPresenterImpl provideResultFragmentPresenter() {
        return new ResultFragmentPresenterImpl();
    }

}
