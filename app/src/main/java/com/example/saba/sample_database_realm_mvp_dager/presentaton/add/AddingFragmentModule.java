package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;


import dagger.Module;
import dagger.Provides;

@Module
public class AddingFragmentModule {

    @Provides
    static AddingFragmentPresenterImpl provideAddingFragmentPresenter() {
        return new AddingFragmentPresenterImpl();
    }

}
