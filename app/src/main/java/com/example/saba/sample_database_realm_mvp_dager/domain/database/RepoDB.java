package com.example.saba.sample_database_realm_mvp_dager.domain.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.saba.sample_database_realm_mvp_dager.domain.database.daos.RepoDao;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;

@Database(entities = GitHubRepo.class, version = 1, exportSchema = false)
public abstract class RepoDB extends RoomDatabase{

    public abstract RepoDao repoDao();

}
