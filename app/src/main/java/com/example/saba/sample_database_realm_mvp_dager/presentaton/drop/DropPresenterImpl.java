package com.example.saba.sample_database_realm_mvp_dager.presentaton.drop;


import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.DropAllUseCase;

public class DropPresenterImpl extends BasePresenter<DropView> implements DropPresenter{

    private DropAllUseCase dropAllUseCase;

    public DropPresenterImpl(DropAllUseCase dropAllUseCase) {
        this.dropAllUseCase = dropAllUseCase;
    }

    @Override
    public void drop() {
        dropAllUseCase.drop();
    }
}

