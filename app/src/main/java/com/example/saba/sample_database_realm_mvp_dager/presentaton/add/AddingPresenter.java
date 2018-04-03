package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import android.util.Log;

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
         mCompositeDisposable.add(
                 getStarredReposUseCase.getStarredRepos(userName)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(mView::updateList));
    }

    public void subscribeUserAction(Observable<GitHubRepo> userAction){
        mCompositeDisposable.add(userAction
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(this::saveData)
                .subscribe(this::log));
    }

    private Observable<GitHubRepo> saveData(GitHubRepo repo) {
        return saveDataUseCase.save(repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void goToResultsScreen() {
        addingNavigator.goToResultsScreen();
    }

    private void log(GitHubRepo repo){
        Log.i("saved: ",repo.getName());
    }

}
