package com.example.saba.sample_database_realm_mvp_dager.presentaton.get;

import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerFragment;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.DropUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SelectAllUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class ResultFragmentModule {

    @Provides
    @PerFragment
    static ResultPresenter provideResultFragmentPresenter(SelectAllUseCase selectAllUseCase, DropUseCase dropUseCase, ResultsNavigator resultsNavigator) {
        return new ResultPresenter(selectAllUseCase, dropUseCase, resultsNavigator);
    }

}
