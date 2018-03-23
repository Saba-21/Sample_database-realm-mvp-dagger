package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;


import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;
import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.realm.RealmResults;


public class SelectByModelUseCase extends BaseUseCase {

    @Inject
    public SelectByModelUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public RealmResults<CarModel> select(String model){
        return mRepository.selectByModel(model);
    }

}
