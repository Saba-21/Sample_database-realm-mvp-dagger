package com.example.saba.sample_database_realm_mvp_dager.presentaton.results;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.base.BaseFragment;
import com.zuluft.autoadapter.AutoAdapter;
import com.zuluft.generated.AutoAdapterFactory;
import dagger.android.support.AndroidSupportInjection;


public class ResultFragment extends BaseFragment<ResultFragmentPresenterImpl> implements ResultsView{

    private Context context;


    public ResultFragment() {
    }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        mPresenter.attach(this);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        AutoAdapter autoAdapter = AutoAdapterFactory.createAutoAdapter();
        autoAdapter.addAll(Stream.of(mPresenter.getAllObjects()).map(CarListRenderer::new).collect(Collectors.toList()));

        recyclerView.setAdapter(autoAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        this.context = context;
    }

}
