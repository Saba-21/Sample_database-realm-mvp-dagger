package com.example.saba.sample_database_realm_mvp_dager.presentaton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
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

        findViewById(R.id.add_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, AddingFragment.newInstance()).commit();
            }
        });

        findViewById(R.id.drop_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, DropFragment.newInstance()).commit();
            }
        });
        findViewById(R.id.result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, ResultFragment.newInstance()).commit();
            }
        });

        findViewById(R.id.select_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getTest();
            }
        });
    }

    @Override
    public void showTest() {
        Toast.makeText(this, "activity test success", Toast.LENGTH_SHORT).show();
    }
}
