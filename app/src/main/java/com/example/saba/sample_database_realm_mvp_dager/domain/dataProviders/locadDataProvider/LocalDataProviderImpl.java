package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider;

import com.example.saba.sample_database_realm_mvp_dager.domain.database.RepoDB;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import java.util.List;
import io.reactivex.Observable;

public class LocalDataProviderImpl implements LocalDataProvider {

    private RepoDB repoDB;

    public LocalDataProviderImpl(RepoDB repoDB) {
        this.repoDB = repoDB;
    }

    @Override
    public Observable<GitHubRepo> saveData(GitHubRepo repo) {
        return Observable.fromCallable(()->saveDataDb(repo));
    }

    @Override
    public Observable<List<GitHubRepo>> selectAll() {
        return repoDB.repoDao().selectAll().toObservable();
    }

    @Override
    public Observable<GitHubRepo> drop(GitHubRepo repo) {
        return Observable.fromCallable(() -> dropDataDb(repo));
    }

    private GitHubRepo saveDataDb(GitHubRepo repo){
        repoDB.repoDao().insert(repo);
        return repo;
    }
    private GitHubRepo dropDataDb(GitHubRepo repo){
        repoDB.repoDao().drop(repo);
        return repo;
    }

}
