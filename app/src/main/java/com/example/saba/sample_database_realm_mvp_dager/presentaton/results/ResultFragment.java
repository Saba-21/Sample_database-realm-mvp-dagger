package com.example.saba.sample_database_realm_mvp_dager.presentaton.results;

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
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.zuluft.autoadapter.AutoAdapter;
import com.zuluft.generated.AutoAdapterFactory;
import java.util.List;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ResultFragment extends BaseFragment<ResultFragmentPresenterImpl> implements ResultsView{

    private Context context;
    private AutoAdapter autoAdapter;

    public ResultFragment() {
    }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        mPresenter.attach(this);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        autoAdapter = AutoAdapterFactory.createAutoAdapter();
        recyclerView.setAdapter(autoAdapter);

        getData();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        this.context = context;
    }

    private void getData(){
         mPresenter.getAllObjects()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CarModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onNext(List<CarModel> carModels) {
                        autoAdapter.addAll(Stream.of(carModels)
                                .map(CarListRenderer::new)
                                .collect(Collectors.toList()));
                        autoAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) { }

                    @Override
                    public void onComplete() { }
                });
    }

}
