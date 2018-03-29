package com.example.saba.sample_database_realm_mvp_dager.presentaton.get;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import java.util.List;
import io.reactivex.Observable;

public interface ResultFragmentPresenter {

    Observable<List<GitHubRepo>> getData();

    Observable<Integer> dropData(int position);

}
