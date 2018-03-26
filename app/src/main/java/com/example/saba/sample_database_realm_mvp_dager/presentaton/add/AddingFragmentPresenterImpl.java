package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;


import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SaveDataUseCase;

public class AddingFragmentPresenterImpl extends BasePresenter<AddingView> implements AddingFragmentPresenter {

    private SaveDataUseCase saveDataUseCase;

    AddingFragmentPresenterImpl(SaveDataUseCase saveDataUseCase) {
        this.saveDataUseCase = saveDataUseCase;
    }

    @Override
    public void
    addObject(String mark, String model, String type, String country, String id) {
        if (!(mark.isEmpty()&&model.isEmpty()&&type.isEmpty()&&country.isEmpty()&&id.isEmpty())) {
            saveDataUseCase.save(new CarModel(mark, model, type, country, Integer.parseInt(id)));
        }
    }

}
