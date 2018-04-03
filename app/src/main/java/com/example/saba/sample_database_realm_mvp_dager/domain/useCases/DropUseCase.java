package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import io.reactivex.Observable;

public class DropUseCase extends BaseUseCase {

    @Inject
    DropUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public Observable<GitHubRepo> drop(GitHubRepo gitHubRepo){
        return mRepository.drop(gitHubRepo);
    }

}
