package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;


import io.reactivex.Observable;

public interface AddingFragmentPresenter {

    Observable<Boolean> addObject(String mark, String model, String type, String country, String id);

}
