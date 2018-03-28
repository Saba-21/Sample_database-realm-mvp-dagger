package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModelConstants;
import java.util.List;
import javax.annotation.Nonnull;
import io.reactivex.Observable;
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
    public Observable<Boolean> saveData(CarModel carModel) {
        Realm realm = createRealmAndBeginTransaction();
        realm.copyToRealmOrUpdate(carModel);
        commitTransactionAndCloseRealm(realm);
        return Observable.just(true);
    }

    @Override
    public Observable<List<CarModel>> selectAll() {
        List<CarModel> models = Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .findAll();
        return Observable.just(models);
    }

    @Override
    public Observable<List<CarModel>> selectByMark(String mark) {
        List<CarModel> models = Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.mark, mark)
                .findAll();
        return Observable.just(models);
    }

    @Override
    public Observable<List<CarModel>> selectByModel(String model) {
        List<CarModel> models =  Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.model, model)
                .findAll();
        return Observable.just(models);
    }

    @Override
    public Observable<List<CarModel>> selectByType(String type) {
        List<CarModel> models =  Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.type, type)
                .findAll();
        return Observable.just(models);
    }

    @Override
    public Observable<List<CarModel>> selectByCountry(String country) {
        List<CarModel> models =  Realm
                .getDefaultInstance()
                .where(CarModel.class)
                .equalTo(CarModelConstants.country, country)
                .findAll();
        return Observable.just(models);
    }

    @Override
    public Observable<Boolean> dropAll() {
        Realm realm = createRealmAndBeginTransaction();
        realm.deleteAll();
        commitTransactionAndCloseRealm(realm);
        return Observable.just(true);
    }

    @Override
    public Observable<Boolean> dropByMark(String mark) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.mark, mark)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
        return Observable.just(true);
    }

    @Override
    public Observable<Boolean> dropByModel(String model) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.model, model)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
        return Observable.just(true);
    }

    @Override
    public Observable<Boolean> dropByType(String type) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.type, type)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
        return Observable.just(true);
    }

    @Override
    public Observable<Boolean> dropByCountry(String country) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(CarModel.class)
                .equalTo(CarModelConstants.country, country)
                .findAll()
                .deleteAllFromRealm();
        commitTransactionAndCloseRealm(realm);
        return Observable.just(true);
    }

}
