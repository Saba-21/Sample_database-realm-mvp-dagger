package com.example.saba.sample_database_realm_mvp_dager.domain.repository;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;

import java.util.List;
import io.reactivex.Observable;

public interface Repository {

    Observable<List<RepoModel>> getStarredRepos(String userName);

    Observable<RepoModel> saveData(RepoModel repoModel);

    Observable<List<RepoModel>> selectAll();

    Observable<RepoModel> drop(RepoModel repoModel);

}
