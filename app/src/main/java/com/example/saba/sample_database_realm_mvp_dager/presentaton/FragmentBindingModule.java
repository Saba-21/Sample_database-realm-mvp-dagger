package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingFragmentModule;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.get.ResultFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.get.ResultFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector(modules = AddingFragmentModule.class)
    abstract AddingFragment provideAddingFragmentFactory();

    @PerFragment
    @ContributesAndroidInjector(modules = ResultFragmentModule.class)
    abstract ResultFragment provideResultFragmentFactory();

}
