package com.example.saba.sample_database_realm_mvp_dager.domain.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CarModel extends RealmObject {

    private String mark;

    private String model;

    private String type;

    private String country;

    @PrimaryKey
    private int id;

    public CarModel() {
    }

    public CarModel(String mark, String model, String type, String country, int id) {
        this.mark = mark;
        this.model = model;
        this.type = type;
        this.country = country;
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
