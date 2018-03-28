package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;


import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.reactivex.Observable;


public class DropByCountryUseCase extends BaseUseCase {

    @Inject
    public DropByCountryUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public Observable<Boolean> drop(String country){
        return mRepository.dropByCountry(country);
    }

}
