package com.example.saba.sample_database_realm_mvp_dager.presentaton.get;

import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.DropUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SelectAllUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ResultFragmentPresenterImpl  extends BasePresenter<ResultsView> implements ResultFragmentPresenter {

    private SelectAllUseCase selectAllUseCase;
    private DropUseCase dropUseCase;

    ResultFragmentPresenterImpl(SelectAllUseCase selectAllUseCase, DropUseCase dropUseCase) {
        this.selectAllUseCase = selectAllUseCase;
        this.dropUseCase = dropUseCase;
    }

    @Override
    public void getData() {
         mCompositeDisposable.add(selectAllUseCase.select()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mView::updateList));
    }

    @Override
    public void dropData(int position) {
        mCompositeDisposable.add(dropUseCase.drop(position)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
        mView.updateList(position);
    }

}
