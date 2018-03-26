package com.example.saba.sample_database_realm_mvp_dager.presentaton.results;


import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerFragment;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SelectAllUseCase;

import dagger.Module;
import dagger.Provides;


@Module
public class ResultFragmentModule {

    @Provides
    @PerFragment
    static ResultFragmentPresenterImpl provideResultFragmentPresenter(SelectAllUseCase selectAllUseCase) {
        return new ResultFragmentPresenterImpl(selectAllUseCase);
    }

}
