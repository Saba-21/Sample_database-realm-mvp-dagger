package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;

public interface AddingFragmentPresenter {

    void addData(GitHubRepo repo);

    void getData(String userName);

}
