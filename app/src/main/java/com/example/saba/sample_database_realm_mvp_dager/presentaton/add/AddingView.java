package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import com.example.saba.sample_database_realm_mvp_dager.base.BaseView;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;
import java.util.List;
import javax.annotation.Nonnull;

interface AddingView extends BaseView{

    void updateList(@Nonnull final List<RepoModel> repos);

}