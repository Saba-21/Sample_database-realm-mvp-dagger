package com.example.saba.sample_database_realm_mvp_dager.presentaton.get;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.base.BaseFragment;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;
import com.example.saba.sample_database_realm_mvp_dager.adapters.ReposRenderer;
import com.zuluft.autoadapter.SortedAutoAdapter;
import com.zuluft.generated.AutoAdapterFactory;
import java.util.List;
import javax.annotation.Nonnull;
import dagger.android.support.AndroidSupportInjection;

public class ResultFragment extends BaseFragment<ResultPresenter> implements ResultsView {

    private SortedAutoAdapter adapter;

    public ResultFragment() { }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = AutoAdapterFactory.createSortedAutoAdapter();
        recyclerView.setAdapter(adapter);

        mPresenter.attach(this);

        view.findViewById(R.id.add)
                .setOnClickListener(v -> mPresenter.goToAddingScreen());

        mPresenter.getData();

        mPresenter.subscribeUserAction(adapter
                .clicks(ReposRenderer.class)
                .map(itemInfo->itemInfo.renderer)
                .map(renderer->renderer.repo));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void updateList(@Nonnull final List<RepoModel> repos){
        adapter.updateAll(Stream.of(repos)
                .map(ReposRenderer::new)
                .collect(Collectors.toList()));
    }

}
