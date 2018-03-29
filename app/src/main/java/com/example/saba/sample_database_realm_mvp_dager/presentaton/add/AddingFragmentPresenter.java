package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import java.util.List;
import io.reactivex.Observable;

public interface AddingFragmentPresenter {

    Observable<Boolean> addData(GitHubRepo repo);

    Observable<List<GitHubRepo>> getData(String userName);

}
