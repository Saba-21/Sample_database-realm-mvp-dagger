package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.GetStarredReposUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SaveDataUseCase;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddingPresenter extends BasePresenter<AddingView> {

    private SaveDataUseCase saveDataUseCase;
    private GetStarredReposUseCase getStarredReposUseCase;
    private AddingNavigator addingNavigator;

    AddingPresenter(SaveDataUseCase saveDataUseCase, GetStarredReposUseCase getStarredReposUseCase, AddingNavigator addingNavigator) {
        this.saveDataUseCase = saveDataUseCase;
        this.getStarredReposUseCase = getStarredReposUseCase;
        this.addingNavigator = addingNavigator;
    }

    public void getData(String userName) {
         mCompositeDisposable.addAll(
                 getStarredReposUseCase.getStarredRepos(userName)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(mView::updateList),
                 mView.getUserAction()
                         .subscribeOn(Schedulers.io())
                         .observeOn(AndroidSchedulers.mainThread())
                         .flatMap(this::addData)
                         .subscribe(this::showAdded));
    }

    private Observable<Boolean> addData(GitHubRepo repo) {
        return saveDataUseCase.save(repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void goToResults() {
        addingNavigator.goToResultsScreen();
    }

    private void showAdded(Boolean isAdded){
        if (isAdded)
            mView.showAdded();
    }

}