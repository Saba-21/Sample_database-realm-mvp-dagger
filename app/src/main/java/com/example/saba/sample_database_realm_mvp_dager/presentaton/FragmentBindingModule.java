package com.example.saba.sample_database_realm_mvp_dager.presentaton;


import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingFragmentModule;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.drop.DropFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.drop.DropFragmentModule;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.results.ResultFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.results.ResultFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector(modules = DropFragmentModule.class)
    abstract DropFragment provideDropFragmentFactory();

    @PerFragment
    @ContributesAndroidInjector(modules = AddingFragmentModule.class)
    abstract AddingFragment provideAddingFragmentFactory();

    @PerFragment
    @ContributesAndroidInjector(modules = ResultFragmentModule.class)
    abstract ResultFragment provideResultFragmentFactory();

}
