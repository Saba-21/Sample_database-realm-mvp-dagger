package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders;



import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;

import io.realm.RealmResults;

public interface LocalDataProvider {

    void saveData(CarModel carModel);

    RealmResults<CarModel> selectAll();

    RealmResults<CarModel> selectByMark(String mark);

    RealmResults<CarModel> selectByModel(String model);

    RealmResults<CarModel> selectByType(String type);

    RealmResults<CarModel> selectByCountry(String country);

    void dropAll();

    void dropByMark(String mark);

    void dropByModel(String model);

    void dropByType(String type);

    void dropByCountry(String country);

}
