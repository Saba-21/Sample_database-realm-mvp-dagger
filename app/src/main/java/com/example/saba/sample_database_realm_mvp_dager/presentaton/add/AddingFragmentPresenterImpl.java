package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.GetStarredReposUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SaveDataUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddingFragmentPresenterImpl extends BasePresenter<AddingView> implements AddingFragmentPresenter {

    private final SaveDataUseCase saveDataUseCase;
    private final GetStarredReposUseCase getStarredReposUseCase;

    AddingFragmentPresenterImpl(SaveDataUseCase saveDataUseCase, GetStarredReposUseCase getStarredReposUseCase) {
        this.saveDataUseCase = saveDataUseCase;
        this.getStarredReposUseCase = getStarredReposUseCase;
    }

    @Override
    public void getData(String userName) {
         mCompositeDisposable.add(getStarredReposUseCase.getStarredRepos(userName)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(mView::updateList));
    }

    @Override
    public void addData(GitHubRepo repo) {
        mCompositeDisposable.add(saveDataUseCase.save(repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

}
