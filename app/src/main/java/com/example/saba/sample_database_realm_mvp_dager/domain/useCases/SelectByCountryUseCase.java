package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;


import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;
import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.reactivex.Observable;


public class SelectByCountryUseCase extends BaseUseCase {

    @Inject
    public SelectByCountryUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public Observable<List<CarModel>> select(String country){
        return mRepository.selectByCountry(country);
    }

}
