package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;


import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;
import javax.annotation.Nonnull;
import javax.inject.Inject;


public class DropByTypeUseCase extends BaseUseCase {

    @Inject
    public DropByTypeUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public void drop(String type){
        mRepository.dropByType(type);
    }

}
