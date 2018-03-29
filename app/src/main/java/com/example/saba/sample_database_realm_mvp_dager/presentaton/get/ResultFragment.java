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
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ResultFragment extends BaseFragment<ResultFragmentPresenterImpl> implements ResultsView {

    private AutoAdapter adapter;
    private Context context;

    public ResultFragment() { }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = AutoAdapterFactory.createAutoAdapter();
        recyclerView.setAdapter(adapter);

        mPresenter.attach(this);

        getData();

        mCompositeDisposable.add(adapter.clicks(ReposRenderer.class)
                .map(itemInfo->itemInfo.position)
                .flatMap(position -> mPresenter.dropData(position).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()))
                .subscribe(this::updateList));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        this.context = context;
    }

    private void updateList(int position){
        adapter.remove(position);
        adapter.notifyItemRemoved(position);
    }

    private void updateList(@Nonnull final List<GitHubRepo> repos){
        adapter.removeAll();
        adapter.addAll(Stream.of(repos)
                .map(ReposRenderer::new)
                .collect(Collectors.toList()));
        adapter.notifyDataSetChanged();
    }

    private void getData() {
        mCompositeDisposable.add(mPresenter.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateList));
    }

}
