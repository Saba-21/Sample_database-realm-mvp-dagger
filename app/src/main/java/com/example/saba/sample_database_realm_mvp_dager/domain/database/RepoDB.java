package com.example.saba.sample_database_realm_mvp_dager.domain.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.saba.sample_database_realm_mvp_dager.domain.database.daos.RepoDao;
import com.example.saba.sample_database_realm_mvp_dager.domain.database.daos.UserDao;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels.OwnerDbModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels.RepoDbModel;

@Database(entities = {RepoDbModel.class, OwnerDbModel.class},
                version = 9,
                exportSchema = false)
public abstract class RepoDB extends RoomDatabase{

    public abstract RepoDao repoDao();

    public abstract UserDao userDao();

}
