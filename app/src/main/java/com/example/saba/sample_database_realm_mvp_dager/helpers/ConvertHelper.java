package com.example.saba.sample_database_realm_mvp_dager.helpers;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels.OwnerDbModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels.RepoDbModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.OwnerModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;

import java.util.ArrayList;
import java.util.List;

public final class ConvertHelper {

    public static RepoModel toRepoModel(RepoDbModel repo, OwnerDbModel owner){
        return new RepoModel(repo.getId(), repo.getName(), repo.getLanguage(), repo.getStarCount(), new OwnerModel(owner.getLogin(), owner.getAvatar()));
    }

    public static RepoDbModel toRepoDbModel(RepoModel repo){
        return new RepoDbModel(repo.getId(), repo.getName(), repo.getLanguage(), repo.getStarCount());
    }

    public static OwnerDbModel toOwnerDbModel(RepoModel repo){
        return new OwnerDbModel(repo.getId(), repo.getOwner().getLogin(), repo.getOwner().getAvatar());
    }

    public static List<RepoModel> toListRepos(List<RepoDbModel>repos, List<OwnerDbModel>owners){
        List<RepoModel> repoModels = new ArrayList<>();
        for (int i = 0; i < repos.size(); i++)
            if (repos.get(i).getId() == owners.get(i).getRepoId())
                repoModels.add(toRepoModel(repos.get(i),owners.get(i)));
        return repoModels;
    }

}
