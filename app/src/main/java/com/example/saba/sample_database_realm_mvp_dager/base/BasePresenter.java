package com.example.saba.sample_database_realm_mvp_dager.base;


import javax.annotation.Nonnull;

public class BasePresenter<T extends BaseView> {

    protected T mView;

    public final void attach(@Nonnull final T view) {
        mView = view;
    }

    public final void detach() {
        mView = null;
    }
}
