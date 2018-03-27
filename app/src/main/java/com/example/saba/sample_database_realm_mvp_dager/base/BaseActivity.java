package com.example.saba.sample_database_realm_mvp_dager.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements HasSupportFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Fragment> mDispatchingAndroidInjector;

    @Inject
    protected P mPresenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return mDispatchingAndroidInjector;
    }
}
