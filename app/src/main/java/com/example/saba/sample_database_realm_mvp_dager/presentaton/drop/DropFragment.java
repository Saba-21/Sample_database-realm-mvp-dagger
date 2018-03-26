package com.example.saba.sample_database_realm_mvp_dager.presentaton.drop;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.saba.sample_database_realm_mvp_dager.R;
import javax.inject.Inject;
import butterknife.OnClick;
import dagger.android.support.DaggerFragment;

public class DropFragment extends DaggerFragment implements DropView {

    @OnClick(R.id.drop) void add() {
        mPresenter.drop();
    }

        @Inject
    DropPresenterImpl mPresenter;

    public DropFragment() {
    }

    public static DropFragment newInstance() { return new DropFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drop, container, false);

        mPresenter.attach(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
