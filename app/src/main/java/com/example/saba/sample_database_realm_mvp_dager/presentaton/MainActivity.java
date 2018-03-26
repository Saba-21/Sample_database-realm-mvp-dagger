package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import android.os.Bundle;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.add.AddingFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.drop.DropFragment;
import com.example.saba.sample_database_realm_mvp_dager.presentaton.results.ResultFragment;
import javax.inject.Inject;
import dagger.android.support.DaggerAppCompatActivity;


public class MainActivity extends DaggerAppCompatActivity implements MainView {

    @Inject
    MainPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.attach(this);

        findViewById(R.id.add_fragment).setOnClickListener(view ->
                getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_result, AddingFragment.newInstance())
                .commit());

        findViewById(R.id.drop_fragment).setOnClickListener(view ->
                getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_result, DropFragment.newInstance())
                .commit());

        findViewById(R.id.get_fragment).setOnClickListener(v ->
                getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_result, ResultFragment.newInstance())
                .commit());

    }

}
