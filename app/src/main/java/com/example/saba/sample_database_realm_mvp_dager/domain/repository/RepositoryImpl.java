package com.example.saba.sample_database_realm_mvp_dager.domain.repository;



import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.LocalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;

import javax.annotation.Nonnull;

import io.realm.RealmResults;

public class RepositoryImpl implements Repository {

    private final LocalDataProvider mLocalDataProvider;

    public RepositoryImpl(@Nonnull final LocalDataProvider localDataProvider) {
        this.mLocalDataProvider = localDataProvider;
    }

    @Override
    public void saveData(CarModel carModel) {
        mLocalDataProvider.saveData(carModel);
    }

    @Override
    public RealmResults<CarModel> selectAll() {
        return mLocalDataProvider.selectAll();
    }

    @Override
    public RealmResults<CarModel> selectByMark(String mark) {
        return mLocalDataProvider.selectByMark(mark);
    }

    @Override
    public RealmResults<CarModel> selectByModel(String model) {
        return mLocalDataProvider.selectByModel(model);
    }

    @Override
    public RealmResults<CarModel> selectByType(String type) {
        return mLocalDataProvider.selectByType(type);
    }

    @Override
    public RealmResults<CarModel> selectByCountry(String country) {
        return mLocalDataProvider.selectByCountry(country);
    }

    @Override
    public void dropAll() {
        mLocalDataProvider.dropAll();
    }

    @Override
    public void dropByMark(String mark) {
        mLocalDataProvider.dropByMark(mark);
    }

    @Override
    public void dropByModel(String model) {
        mLocalDataProvider.dropByModel(model);
    }

    @Override
    public void dropByType(String type) {
        mLocalDataProvider.dropByType(type);
    }

    @Override
    public void dropByCountry(String country) {
        mLocalDataProvider.dropByCountry(country);
    }
}
