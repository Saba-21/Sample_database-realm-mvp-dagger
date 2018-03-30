package com.example.saba.sample_database_realm_mvp_dager.presentaton.add;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.adapters.ReposRenderer;
import com.example.saba.sample_database_realm_mvp_dager.base.BaseFragment;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.zuluft.autoadapter.AutoAdapter;
import com.zuluft.generated.AutoAdapterFactory;
import java.util.List;
import javax.annotation.Nonnull;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observable;

public class AddingFragment extends BaseFragment<AddingPresenter> implements AddingView{

    private AutoAdapter adapter;
    private Context context;

    public AddingFragment() { }

    public static AddingFragment newInstance() {
        return new AddingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adding, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.repos_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = AutoAdapterFactory.createAutoAdapter();
        recyclerView.setAdapter(adapter);

        mPresenter.attach(this);

        view.findViewById(R.id.get).setOnClickListener(v -> mPresenter.goToResults());
        EditText nameField = view.findViewById(R.id.username);
        view.findViewById(R.id.search)
                .setOnClickListener(v-> mPresenter.getData(nameField.getText().toString().trim()));

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
    public void showAdded() {
        Toast.makeText(context, "repo added", Toast.LENGTH_SHORT).show();
    }

}
