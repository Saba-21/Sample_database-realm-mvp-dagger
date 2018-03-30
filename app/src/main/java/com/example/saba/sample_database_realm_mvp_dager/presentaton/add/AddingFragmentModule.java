package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import com.example.saba.sample_database_realm_mvp_dager.base.scopes.PerFragment;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.GetStarredReposUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SaveDataUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class AddingFragmentModule {

    @Provides
    @PerFragment
    static AddingPresenter provideAddingFragmentPresenter(SaveDataUseCase saveDataUseCase, GetStarredReposUseCase getStarredReposUseCase, AddingNavigator addingNavigator) {
        return new AddingPresenter(saveDataUseCase, getStarredReposUseCase, addingNavigator);
    }

}
