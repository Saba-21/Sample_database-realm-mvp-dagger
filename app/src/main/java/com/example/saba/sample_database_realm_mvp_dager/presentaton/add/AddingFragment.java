package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.saba.sample_database_realm_mvp_dager.R;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.support.DaggerFragment;

public class AddingFragment extends DaggerFragment implements AddingView{

    @BindView(R.id.mark_input) EditText mark;
    @BindView(R.id.model_input) EditText model;
    @BindView(R.id.type_input) EditText type;
    @BindView(R.id.country_input) EditText country;
    @BindView(R.id.ID_input) EditText id;

    @OnClick(R.id.add) void add(){
        mPresenter.addObject(
                mark.getText().toString(),
                model.getText().toString(),
                type.getText().toString(),
                country.getText().toString(),
                id.getText().toString());
        clear();
    }

    @Inject
    AddingFragmentPresenterImpl mPresenter;

    public AddingFragment() {
    }

    public static AddingFragment newInstance() {
        return new AddingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adding, container, false);

        mPresenter.attach(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    void clear(){
        mark.getText().clear();
        model.getText().clear();
        type.getText().clear();
        country.getText().clear();
        id.getText().clear();
    }

}
