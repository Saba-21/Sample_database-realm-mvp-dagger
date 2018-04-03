package com.example.saba.sample_database_realm_mvp_dager.domain.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "repos")
public class GitHubRepo {

    @PrimaryKey
    private  int id;
    private  String name;
    private  String language;
    @SerializedName("stargazers_count")
    private  int starCount;

    @Ignore
    public GitHubRepo(int id, String name, String language, int starCount) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.starCount = starCount;
    }

    public GitHubRepo() {
        this.id = 0;
        this.name = "";
        this.language = "";
        this.starCount = 0;
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
