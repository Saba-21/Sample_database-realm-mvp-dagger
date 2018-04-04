package com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels;

import com.google.gson.annotations.SerializedName;

public class RepoModel {

    private  int id;
    private  String name;
    private  String language;
    @SerializedName("stargazers_count")
    private  int starCount;
    private OwnerModel owner;

    public RepoModel() { }

    public RepoModel(int id, String name, String language, int starCount, OwnerModel owner) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.starCount = starCount;
        this.owner = owner;
    }

    public OwnerModel getOwner() { return owner; }

    public void setOwner(OwnerModel owner) { this.owner = owner; }

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
