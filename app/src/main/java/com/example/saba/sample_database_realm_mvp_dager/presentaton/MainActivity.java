package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import android.os.Bundle;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.base.BaseActivity;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.get.ResultFragment;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.attach(this);
        mPresenter.goToAddingScreen();
    }

    @Override
    public void drawAddFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main, AddingFragment.newInstance())
                .commit();
    }

    @Override
    public void drawGetFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main, ResultFragment.newInstance())
                .commit();
    }
}
