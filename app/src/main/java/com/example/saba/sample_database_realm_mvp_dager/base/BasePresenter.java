package com.example.saba.sample_database_realm_mvp_dager.base;


import javax.annotation.Nonnull;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<T extends BaseView> {

    protected CompositeDisposable mCompositeDisposable;

    protected T mView;

    public BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public final void attach(@Nonnull final T view) {
        mView = view;
    }

    public final void detach() {
        mView = null;
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
    }
}
