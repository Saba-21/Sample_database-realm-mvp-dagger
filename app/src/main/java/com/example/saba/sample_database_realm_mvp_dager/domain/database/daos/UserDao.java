package com.example.saba.sample_database_realm_mvp_dager.domain.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels.OwnerDbModel;
import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(OwnerDbModel owner);

    @Query("Select * From owners")
    List<OwnerDbModel> selectAll();

    @Delete
    void drop(OwnerDbModel owner);

}
