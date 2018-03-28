package com.example.saba.sample_database_realm_mvp_dager.domain.repository;


import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.LocalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import java.util.List;
import javax.annotation.Nonnull;

import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    private final LocalDataProvider mLocalDataProvider;

    public RepositoryImpl(@Nonnull final LocalDataProvider localDataProvider) {
        this.mLocalDataProvider = localDataProvider;
    }

    @Override
    public Observable<Boolean> saveData(CarModel carModel) {
       return mLocalDataProvider.saveData(carModel);
    }

    @Override
    public Observable<List<CarModel>> selectAll() {
        return mLocalDataProvider.selectAll();
    }

    @Override
    public Observable<List<CarModel>> selectByMark(String mark) {
        return mLocalDataProvider.selectByMark(mark);
    }

    @Override
    public Observable<List<CarModel>> selectByModel(String model) {
        return mLocalDataProvider.selectByModel(model);
    }

    @Override
    public Observable<List<CarModel>> selectByType(String type) {
        return mLocalDataProvider.selectByType(type);
    }

    @Override
    public Observable<List<CarModel>> selectByCountry(String country) {
        return mLocalDataProvider.selectByCountry(country);
    }

    @Override
    public Observable<Boolean> dropAll() {
        return mLocalDataProvider.dropAll();
    }

    @Override
    public Observable<Boolean> dropByMark(String mark) {
        return mLocalDataProvider.dropByMark(mark);
    }

    @Override
    public Observable<Boolean> dropByModel(String model) {
       return mLocalDataProvider.dropByModel(model);
    }

    @Override
    public Observable<Boolean> dropByType(String type) {
        return mLocalDataProvider.dropByType(type);
    }

    @Override
    public Observable<Boolean> dropByCountry(String country) {
        return mLocalDataProvider.dropByCountry(country);
    }
}
