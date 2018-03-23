package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.saba.sample_database_realm_mvp_dager.R;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class AddingFragment extends DaggerFragment implements AddingView{

    private Context context;

    @Inject
    AddingFragmentPresenterImpl mPresenter;

    public AddingFragment() {
    }

    public static AddingFragment newInstance() {
        AddingFragment fragment = new AddingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adding, container, false);

        mPresenter.attach(this);

        mPresenter.getTest();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void showTest() {
        Toast.makeText(context, "adding fragment test success", Toast.LENGTH_SHORT).show();
    }

}
