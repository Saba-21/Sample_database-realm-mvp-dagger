package com.example.saba.sample_database_realm_mvp_dager.presentaton;


import com.example.saba.sample_database_realm_mvp_dager.base.BasePresenter;


public class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter{

    MainPresenterImpl() { }

    @Override
    public void drawAddFragment() {
        mView.drawAddFragment();
    }

    @Override
    public void drawGetFragment() {
        mView.drawGetFragment();
    }
}
