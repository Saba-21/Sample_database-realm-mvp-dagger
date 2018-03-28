package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;


import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SaveDataUseCase;

import io.reactivex.Observable;

public class AddingFragmentPresenterImpl extends BasePresenter<AddingView> implements AddingFragmentPresenter {

    private final SaveDataUseCase saveDataUseCase;

    AddingFragmentPresenterImpl(SaveDataUseCase saveDataUseCase) {
        this.saveDataUseCase = saveDataUseCase;
    }

    @Override
    public Observable<Boolean> addObject(String mark, String model, String type, String country, String id) {
        if (!(mark.isEmpty()&&model.isEmpty()&&type.isEmpty()&&country.isEmpty()&&id.isEmpty())) {
            return saveDataUseCase.save(new CarModel(mark, model, type, country, Integer.parseInt(id)));
        }
        else return Observable.just(false);
    }

}
