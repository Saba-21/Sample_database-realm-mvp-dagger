package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saba.sample_database_realm_mvp_dager.R;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class AddingFragment extends DaggerFragment implements AddingView{

    private EditText mark, model, type, country, id;

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

        mark = view.findViewById(R.id.mark_input);
        model = view.findViewById(R.id.model_input);
        type = view.findViewById(R.id.type_input);
        country = view.findViewById(R.id.country_input);
        id = view.findViewById(R.id.ID_input);

        mPresenter.attach(this);

        view.findViewById(R.id.add).setOnClickListener(v -> {
            mPresenter.addObject(
                    mark.getText().toString(),
                    model.getText().toString(),
                    type.getText().toString(),
                    country.getText().toString(),
                    id.getText().toString());
            clear();
        });

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
