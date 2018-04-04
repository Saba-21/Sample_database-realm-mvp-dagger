package com.example.saba.sample_database_realm_mvp_dager.domain.repository;

import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.globalDataProvider.GlobalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider.LocalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;

import java.util.List;
import javax.annotation.Nonnull;
import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    private final LocalDataProvider mLocalDataProvider;

    private final GlobalDataProvider mGlobalDataProvider;

    public RepositoryImpl(@Nonnull final LocalDataProvider localDataProvider, @Nonnull final GlobalDataProvider globalDataProvider) {
        this.mLocalDataProvider = localDataProvider;
        this.mGlobalDataProvider = globalDataProvider;
    }

    public Observable<List<RepoModel>> getStarredRepos (String userName) {
        return mGlobalDataProvider.getStarredRepositories(userName);
    }

    @Override
    public Observable<RepoModel> saveData(RepoModel repoModel) {
       return mLocalDataProvider.saveData(repoModel);
    }

    @Override
    public Observable<List<RepoModel>> selectAll() {
        return mLocalDataProvider.selectAll();
    }

    @Override
    public Observable<RepoModel> drop(RepoModel repoModel) {
        return mLocalDataProvider.drop(repoModel);
    }

}
