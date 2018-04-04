package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;

import java.util.List;
import io.reactivex.Observable;

public interface LocalDataProvider {

    Observable<RepoModel> saveData(RepoModel repoModel);

    Observable<List<RepoModel>> selectAll();

    Observable<RepoModel> drop(RepoModel repoModel);

}
