package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import java.util.List;
import io.reactivex.Observable;

public interface LocalDataProvider {

    Observable<GitHubRepo> saveData(GitHubRepo gitHubRepo);

    Observable<List<GitHubRepo>> selectAll();

    Observable<GitHubRepo> drop(GitHubRepo gitHubRepo);

}
