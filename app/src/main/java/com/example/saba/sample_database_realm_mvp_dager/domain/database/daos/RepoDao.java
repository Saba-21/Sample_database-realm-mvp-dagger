package com.example.saba.sample_database_realm_mvp_dager.domain.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import java.util.List;
import io.reactivex.Flowable;

@Dao
public interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GitHubRepo gitHubRepo);

    @Query("Select * From repos")
    Flowable<List<GitHubRepo>> selectAll();

    @Delete
    void drop(GitHubRepo gitHubRepo);

}
