package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerActivity;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.DropAllUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SaveDataUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SelectAllUseCase;

import dagger.Module;
import dagger.Provides;


@Module
public class MainActivityModule {

    @Provides
    @PerActivity
    static MainPresenterImpl provideMainPresenter() {
        return new MainPresenterImpl();
    }

}
