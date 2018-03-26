package com.example.saba.sample_database_realm_mvp_dager.presentaton.drop;


import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerFragment;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.DropAllUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DropFragmentModule {

    @Provides
    @PerFragment
    static DropPresenterImpl provideDropFragmentPresenter(DropAllUseCase dropAllUseCase) {
        return new DropPresenterImpl(dropAllUseCase);
    }

}
