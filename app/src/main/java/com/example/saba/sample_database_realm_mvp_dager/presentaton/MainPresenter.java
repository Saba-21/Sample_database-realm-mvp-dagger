package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingNavigator;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.get.ResultsNavigator;

public class MainPresenter extends BasePresenter<MainView>
        implements AddingNavigator, ResultsNavigator{

    MainPresenter() { }

    @Override
    public void goToResultsScreen() {
        mView.drawGetFragment();
    }

    @Override
    public void goToAddingScreen() {
        mView.drawAddFragment();
    }
}
