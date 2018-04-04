package com.example.saba.sample_database_realm_mvp_dager.presentaton.get;

import android.util.Log;

import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.DropUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SelectAllUseCase;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ResultPresenter extends BasePresenter<ResultsView> {

    private SelectAllUseCase selectAllUseCase;
    private DropUseCase dropUseCase;
    private ResultsNavigator resultsNavigator;

    ResultPresenter(SelectAllUseCase selectAllUseCase, DropUseCase dropUseCase, ResultsNavigator resultsNavigator) {
        this.selectAllUseCase = selectAllUseCase;
        this.dropUseCase = dropUseCase;
        this.resultsNavigator = resultsNavigator;
    }

    public void getData() {
         mCompositeDisposable.add(
                 selectAllUseCase.select()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(mView::updateList));
    }

    public void subscribeUserAction(Observable<RepoModel> userAction){
        mCompositeDisposable.add(userAction
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(this::dropData)
                .subscribe(this::log));
    }

    private Observable<RepoModel> dropData(RepoModel repoModel) {
        return dropUseCase.drop(repoModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void goToAddingScreen() {
        resultsNavigator.goToAddingScreen();
    }

    private void log(RepoModel repo){ Log.i("deleted: ",repo.getName()); }

}
