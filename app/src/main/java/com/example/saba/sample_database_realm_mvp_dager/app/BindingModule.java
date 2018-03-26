package com.example.saba.sample_database_realm_mvp_dager.app;


import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerActivity;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.FragmentBindingModule;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.MainActivity;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentBindingModule.class})
    public abstract MainActivity contributeMainActivityInjector();

}