package com.example.saba.sample_database_realm_mvp_dager.presentaton.drop;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.base.BaseFragment;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DropFragment extends BaseFragment<DropPresenterImpl> implements DropView {

    public DropFragment() {
    }

    public static DropFragment newInstance() { return new DropFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drop, container, false);
        view.findViewById(R.id.drop).setOnClickListener(v -> dropData());
        mPresenter.attach(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    private void dropData(){
        mCompositeDisposable.add(mPresenter.drop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result->Log.i("onNext",Boolean.toString(result))));
    }

}
