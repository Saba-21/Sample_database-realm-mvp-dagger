package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;


import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;
import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.reactivex.Observable;


public class DropByModelUseCase extends BaseUseCase {

    @Inject
    public DropByModelUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public Observable<Boolean> drop(String model){
        return mRepository.dropByModel(model);
    }

}
