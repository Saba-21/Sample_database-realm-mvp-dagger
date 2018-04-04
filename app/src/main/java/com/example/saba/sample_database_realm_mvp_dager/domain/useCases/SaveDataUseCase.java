package com.example.saba.sample_database_realm_mvp_dager.domain.useCases;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;
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

    public Observable<RepoModel> save(RepoModel repoModel){
        return mRepository.saveData(repoModel);
    }

}
