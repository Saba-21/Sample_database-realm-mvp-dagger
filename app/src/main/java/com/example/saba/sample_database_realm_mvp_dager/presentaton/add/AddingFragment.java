package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.base.BaseFragment;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddingFragment extends BaseFragment<AddingFragmentPresenterImpl> implements AddingView{

    private EditText mark,model,type,country,id;

    public AddingFragment() {
    }

    public static AddingFragment newInstance() {
        return new AddingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adding, container, false);
        initView(view);
        view.findViewById(R.id.add_input)
                .setOnClickListener(v -> {
                    addData();
                    clear();
        });
        mPresenter.attach(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    void clear(){
        mark.getText().clear();
        model.getText().clear();
        type.getText().clear();
        country.getText().clear();
        id.getText().clear();
    }

    void initView(View view){
        mark = view.findViewById(R.id.mark_input);
        model = view.findViewById(R.id.model_input);
        type = view.findViewById(R.id.type_input);
        country = view.findViewById(R.id.country_input);
        id = view.findViewById(R.id.ID_input);
    }

    public void addData(){
        mCompositeDisposable.add(mPresenter.addObject(
                mark.getText().toString(),
                model.getText().toString(),
                type.getText().toString(),
                country.getText().toString(),
                id.getText().toString()
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result-> Log.i("onNext",Boolean.toString(result))));
    }

}
