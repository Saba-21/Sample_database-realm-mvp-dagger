package com.example.saba.sample_database_realm_mvp_dager.domain.models;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class GitHubRepo extends RealmObject {

    @PrimaryKey
    private  int id;
    private  String name;
    private  String description;
    private  String language;
    @SerializedName("stargazers_count")
    private  int starCount;

    public GitHubRepo(int id, String name, String description, String language, int starCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.language = language;
        this.starCount = starCount;
    }

    public GitHubRepo() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public int getStarCount() {
        return starCount;
    }

}
