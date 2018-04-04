package com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "owners")
public class OwnerDbModel {

    @PrimaryKey
    private int repoId;
    private String login;
    private String avatar;

    public OwnerDbModel() { }

    @Ignore
    public OwnerDbModel(int repoId, String login, String avatar) {
        this.repoId = repoId;
        this.login = login;
        this.avatar = avatar;
    }

    public int getRepoId() { return repoId; }

    public void setRepoId(int repoId) { this.repoId = repoId; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }
}
