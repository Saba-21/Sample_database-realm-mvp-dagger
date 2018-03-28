package com.example.saba.sample_database_realm_mvp_dager.domain.repository;


import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import java.util.List;
import io.reactivex.Observable;


public interface Repository {

    Observable<Boolean> saveData(CarModel carModel);

    Observable<List<CarModel>> selectAll();

    Observable<List<CarModel>> selectByMark(String mark);

    Observable<List<CarModel>> selectByModel(String model);

    Observable<List<CarModel>> selectByType(String type);

    Observable<List<CarModel>> selectByCountry(String country);

    Observable<Boolean> dropAll();

    Observable<Boolean> dropByMark(String mark);

    Observable<Boolean> dropByModel(String model);

    Observable<Boolean> dropByType(String type);

    Observable<Boolean> dropByCountry(String country);

}
