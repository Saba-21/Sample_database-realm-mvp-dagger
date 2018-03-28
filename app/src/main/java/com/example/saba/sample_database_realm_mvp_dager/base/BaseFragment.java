package com.example.saba.sample_database_realm_mvp_dager.base;

import android.support.v4.app.Fragment;
import javax.inject.Inject;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    @Inject
    protected P mPresenter;

    @Override
    public void onDestroyView() {
        mPresenter.detach();
        super.onDestroyView();
    }

}
