package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import android.os.Bundle;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.base.BaseActivity;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.drop.DropFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.results.ResultFragment;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;


public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainView {


    @OnClick(R.id.add_fragment) void result() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main, AddingFragment.newInstance())
                .commit();
    }
    @OnClick(R.id.drop_fragment) void drop() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main, DropFragment.newInstance())
                .commit();
    }
    @OnClick(R.id.get_fragment) void add() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main, ResultFragment.newInstance())
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter.attach(this);
    }

}
