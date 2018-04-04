package com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels;

import com.google.gson.annotations.SerializedName;

public class OwnerModel {

    private String login;
    @SerializedName("avatar_url")
    private String avatar;

    public OwnerModel() { }

    public OwnerModel(String login, String avatar) {
        this.login = login;
        this.avatar = avatar;
    }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }
}
