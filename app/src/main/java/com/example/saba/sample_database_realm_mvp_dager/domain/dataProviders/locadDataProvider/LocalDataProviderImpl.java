package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
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
    public Observable<Boolean> saveData(GitHubRepo gitHubRepo) {
        Realm realm = createRealmAndBeginTransaction();
        realm.copyToRealmOrUpdate(gitHubRepo);
        commitTransactionAndCloseRealm(realm);
        return Observable.just(true);
    }

    @Override
    public Observable<List<GitHubRepo>> selectAll() {
        Realm realm = Realm.getDefaultInstance();
        List<GitHubRepo> repos = realm.copyFromRealm(realm
                        .where(GitHubRepo.class)
                        .findAll());
        realm.close();
        return Observable.just(repos);
    }

    @Override
    public Observable<Integer> drop(int position) {
        Realm realm = createRealmAndBeginTransaction();
        realm.where(GitHubRepo.class).findAll().deleteFromRealm(position);
        commitTransactionAndCloseRealm(realm);
        return Observable.just(position);
    }

}
