package com.example.saba.sample_database_realm_mvp_dager.presentaton.parameters;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saba.sample_database_realm_mvp_dager.R;


public class ParametersFragment extends Fragment implements ParametersView {

    public ParametersFragment() {
    }

    public static ParametersFragment newInstance() {
        ParametersFragment fragment = new ParametersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_parameters, container, false);
    }

}
