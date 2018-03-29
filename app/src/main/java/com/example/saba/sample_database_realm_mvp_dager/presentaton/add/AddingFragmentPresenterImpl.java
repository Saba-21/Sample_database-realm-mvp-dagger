package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.GetStarredReposUseCase;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.SaveDataUseCase;
import java.util.List;
import io.reactivex.Observable;

public class AddingFragmentPresenterImpl extends BasePresenter<AddingView> implements AddingFragmentPresenter {

    private final SaveDataUseCase saveDataUseCase;
    private final GetStarredReposUseCase getStarredReposUseCase;

    public AddingFragmentPresenterImpl(SaveDataUseCase saveDataUseCase, GetStarredReposUseCase getStarredReposUseCase) {
        this.saveDataUseCase = saveDataUseCase;
        this.getStarredReposUseCase = getStarredReposUseCase;
    }

    @Override
    public Observable<List<GitHubRepo>> getData(String userName) {
        return getStarredReposUseCase.getStarredRepos(userName);
    }

    @Override
    public Observable<Boolean> addData(GitHubRepo repo) {
        return saveDataUseCase.save(repo);
    }

}
