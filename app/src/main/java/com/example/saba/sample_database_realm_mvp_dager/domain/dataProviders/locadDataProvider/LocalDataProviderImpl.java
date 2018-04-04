package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider;

import com.example.saba.sample_database_realm_mvp_dager.domain.database.RepoDB;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels.OwnerDbModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels.RepoDbModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;
import com.example.saba.sample_database_realm_mvp_dager.helpers.ConvertHelper;

import java.util.List;
import io.reactivex.Observable;

public class LocalDataProviderImpl implements LocalDataProvider {

    private RepoDB database;

    public LocalDataProviderImpl(RepoDB database) {
        this.database = database;
    }

    @Override
    public Observable<RepoModel> saveData(RepoModel repoModel) {
        return Observable.fromCallable(()->saveDataDb(repoModel));
    }

    @Override
    public Observable<List<RepoModel>> selectAll() {
        return database.repoDao().selectAll().map(this::mapOwner).toObservable();
    }

    @Override
    public Observable<RepoModel> drop(RepoModel repoModel) {
        return Observable.fromCallable(() -> dropDataDb(repoModel));
    }

    private RepoModel saveDataDb(RepoModel repoModel){
        RepoDbModel repo = ConvertHelper.toRepoDbModel(repoModel);
        OwnerDbModel owner = ConvertHelper.toOwnerDbModel(repoModel);
        database.repoDao().insert(repo);
        database.userDao().insert(owner);
        return ConvertHelper.toRepoModel(repo, owner);

    }
    private RepoModel dropDataDb(RepoModel repoModel){
        RepoDbModel repo = ConvertHelper.toRepoDbModel(repoModel);
        OwnerDbModel owner = ConvertHelper.toOwnerDbModel(repoModel);
        database.repoDao().drop(repo);
        database.userDao().drop(owner);
        return ConvertHelper.toRepoModel(repo, owner);
    }

    private List<RepoModel> mapOwner(List<RepoDbModel> repoDbModels){
        return ConvertHelper.toListRepos(repoDbModels,database.userDao().selectAll());
    }

}
