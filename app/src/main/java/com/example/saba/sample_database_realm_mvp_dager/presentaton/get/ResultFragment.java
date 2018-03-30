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
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.example.saba.sample_database_realm_mvp_dager.adapters.ReposRenderer;
import com.zuluft.autoadapter.AutoAdapter;
import com.zuluft.generated.AutoAdapterFactory;
import java.util.List;
import javax.annotation.Nonnull;
import dagger.android.support.AndroidSupportInjection;

public class ResultFragment extends BaseFragment<ResultPresenter> implements ResultsView {

    private AutoAdapter adapter;
    private Context context;

    public ResultFragment() { }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        view.findViewById(R.id.add).setOnClickListener(v -> mPresenter.goToAdding());

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = AutoAdapterFactory.createAutoAdapter();
        recyclerView.setAdapter(adapter);

        mPresenter.attach(this);

        mPresenter.getData();

        mCompositeDisposable.add(adapter.clicks(ReposRenderer.class)
                .map(itemInfo->itemInfo.position)
                .subscribe(mPresenter::dropData));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void updateList(@Nonnull final List<GitHubRepo> repos){
        adapter.removeAll();
        adapter.addAll(Stream.of(repos)
                .map(ReposRenderer::new)
                .collect(Collectors.toList()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateList(int position) {
        adapter.remove(position);
        adapter.notifyItemRemoved(position);
    }

}
