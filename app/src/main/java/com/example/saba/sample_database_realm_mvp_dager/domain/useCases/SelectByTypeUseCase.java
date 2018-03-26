package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;


import android.content.Context;
import android.util.Log;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;
import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;


public class SelectByTypeUseCase extends BaseUseCase {

    @Inject
    public SelectByTypeUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public List<CarModel> select(String type){
        return mRepository.selectByType(type);
    }

}
