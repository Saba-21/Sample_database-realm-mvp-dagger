package com.example.saba.sample_database_realm_mvp_dager.base;

import android.support.v4.app.Fragment;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected CompositeDisposable mCompositeDisposable;

    @Inject
    protected P mPresenter;

    public BaseFragment() {
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroyView() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
        mPresenter.detach();
        super.onDestroyView();
    }

}
