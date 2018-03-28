package com.example.saba.sample_database_realm_mvp_dager.presentaton.results;


import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;

import java.util.List;

import io.reactivex.Observable;


public interface ResultFragmentPresenter {

    Observable<List<CarModel>> getAllObjects();

}
