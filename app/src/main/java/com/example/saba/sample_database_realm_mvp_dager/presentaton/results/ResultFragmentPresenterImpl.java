package com.example.saba.sample_database_realm_mvp_dager.presentaton.results;


import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SelectAllUseCase;

import java.util.List;

import io.reactivex.Observable;

public class ResultFragmentPresenterImpl  extends BasePresenter<ResultsView> implements ResultFragmentPresenter {

    private SelectAllUseCase selectAllUseCase;

    ResultFragmentPresenterImpl(SelectAllUseCase selectAllUseCase) {
        this.selectAllUseCase = selectAllUseCase;
    }

    @Override
    public Observable<List<CarModel>> getAllObjects() {
        return selectAllUseCase.select();
    }

}
