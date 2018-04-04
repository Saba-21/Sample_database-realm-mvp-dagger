package com.example.saba.sample_database_realm_mvp_dager.domain.models.dbModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "repos")
public class RepoDbModel {

    @PrimaryKey
    private  int id;
    private  String name;
    private  String language;
    private  int starCount;

    public RepoDbModel() { }

    @Ignore
    public RepoDbModel(int id, String name, String language, int starCount) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.starCount = starCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }
}
