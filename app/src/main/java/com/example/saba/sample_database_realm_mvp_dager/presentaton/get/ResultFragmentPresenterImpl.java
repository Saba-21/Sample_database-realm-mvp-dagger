package com.example.saba.sample_database_realm_mvp_dager.presentaton.get;

import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.DropUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SelectAllUseCase;
import java.util.List;
import io.reactivex.Observable;

public class ResultFragmentPresenterImpl  extends BasePresenter<ResultsView> implements ResultFragmentPresenter {

    private SelectAllUseCase selectAllUseCase;
    private DropUseCase dropUseCase;

    ResultFragmentPresenterImpl(SelectAllUseCase selectAllUseCase, DropUseCase dropUseCase) {
        this.selectAllUseCase = selectAllUseCase;
        this.dropUseCase = dropUseCase;
    }

    @Override
    public Observable<List<GitHubRepo>> getData() {
        return selectAllUseCase.select();
    }

    @Override
    public Observable<Integer> dropData(int position) {
        return dropUseCase.drop(position);
    }

}
