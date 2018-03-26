package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders;


import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import java.util.List;


public interface LocalDataProvider {

    void saveData(CarModel carModel);

    List<CarModel> selectAll();

    List<CarModel> selectByMark(String mark);

    List<CarModel> selectByModel(String model);

    List<CarModel> selectByType(String type);

    List<CarModel> selectByCountry(String country);

    void dropAll();

    void dropByMark(String mark);

    void dropByModel(String model);

    void dropByType(String type);

    void dropByCountry(String country);

}
