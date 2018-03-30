package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingNavigator;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.get.ResultsNavigator;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigatorBindingModule {

    @Binds
    abstract AddingNavigator BindAddingNavigator(MainPresenter presenter);

    @Binds
    abstract ResultsNavigator BindResultsNavigator(MainPresenter presenter);

}
