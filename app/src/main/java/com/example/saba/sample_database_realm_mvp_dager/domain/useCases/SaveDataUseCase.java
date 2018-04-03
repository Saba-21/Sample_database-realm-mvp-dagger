package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.useCases.base.BaseUseCase;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import io.reactivex.Observable;

public class SaveDataUseCase extends BaseUseCase {

    @Inject
    SaveDataUseCase(@Nonnull Repository mRepository) {
        super(mRepository);
    }

    public Observable<GitHubRepo> save(GitHubRepo gitHubRepo){
        return mRepository.saveData(gitHubRepo);
    }

}
