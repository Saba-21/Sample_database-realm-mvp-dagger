package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders;


import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModelConstants;
import java.util.List;
import javax.annotation.Nonnull;
import io.realm.Realm;

public class LocalDataProviderImpl implements LocalDataProvider {

    public LocalDataProviderImpl() {
    }

    private Realm createRealmAndBeginTransaction() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        return realm;
    }

    private void commitTransactionAndCloseRealm(@Nonnull final Realm realm) {
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void saveData(CarModel carModel) {
        Realm realm = createRealmAndBeginTransaction();
        realm.copyToRealmOrUpdate(carModel);
        commitTransactionAndCloseRealm(realm);
    }

    @Override
    public List<CarModel> selectAll() {
        return Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .findAll();
    }

    @Override
    public void dropAll() {
        Realm realm = createRealmAndBeginTransaction();
        realm.deleteAll();
        commitTransactionAndCloseRealm(realm);
    }

    @Override
    public List<CarModel> selectByMark(String mark) {
        return Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.mark, mark)
                .findAll();
    }

    @Override
    public List<CarModel> selectByModel(String model) {
        return Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.model, model)
                .findAll();
    }

    @Override
    public List<CarModel> selectByType(String type) {
        return Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.type, type)
                .findAll();
    }

    @Override
    public List<CarModel> selectByCountry(String country) {
        return Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.country, country)
                .findAll();
    }

    @Override
    public void dropByMark(String mark) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.mark, mark)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
    }

    @Override
    public void dropByModel(String model) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.model, model)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
    }

    @Override
    public void dropByType(String type) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.type, type)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
    }

    @Override
    public void dropByCountry(String country) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.country, country)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
    }

}
