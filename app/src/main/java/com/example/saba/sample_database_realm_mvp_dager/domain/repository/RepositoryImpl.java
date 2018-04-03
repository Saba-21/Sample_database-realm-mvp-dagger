package com.example.saba.sample_database_realm_mvp_dager.domain.repository;

import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.globalDataProvider.GlobalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider.LocalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
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

    public Observable<List<GitHubRepo>> getStarredRepos (String userName) {
        return mGlobalDataProvider.getStarredRepositories(userName);
    }

    @Override
    public Observable<GitHubRepo> saveData(GitHubRepo gitHubRepo) {
       return mLocalDataProvider.saveData(gitHubRepo);
    }

    @Override
    public Observable<List<GitHubRepo>> selectAll() {
        return mLocalDataProvider.selectAll();
    }

    @Override
    public Observable<GitHubRepo> drop(GitHubRepo gitHubRepo) {
        return mLocalDataProvider.drop(gitHubRepo);
    }

}
