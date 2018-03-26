package com.example.saba.sample_database_realm_mvp_dager.presentaton.drop;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.saba.sample_database_realm_mvp_dager.R;
import javax.inject.Inject;
import dagger.android.support.DaggerFragment;

public class DropFragment extends DaggerFragment implements DropView {

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

        view.findViewById(R.id.drop).setOnClickListener(v ->
          mPresenter.drop());

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
