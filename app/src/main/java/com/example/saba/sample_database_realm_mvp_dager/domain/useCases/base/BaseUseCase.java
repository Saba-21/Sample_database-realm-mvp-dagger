package com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base;


import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;

import javax.annotation.Nonnull;

public class BaseUseCase {

    protected final Repository mRepository;


    public BaseUseCase(@Nonnull Repository mRepository) {
        this.mRepository = mRepository;
    }

}
