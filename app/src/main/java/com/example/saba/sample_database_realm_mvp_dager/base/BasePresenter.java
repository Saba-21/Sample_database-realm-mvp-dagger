package com.example.saba.sample_database_realm_mvp_dager.base;


import javax.annotation.Nonnull;

public class BasePresenter<T> {

    protected T mView;

    final void attach(@Nonnull final T view) {
        mView = view;
    }

    final void detach() {
        mView = null;
    }
}