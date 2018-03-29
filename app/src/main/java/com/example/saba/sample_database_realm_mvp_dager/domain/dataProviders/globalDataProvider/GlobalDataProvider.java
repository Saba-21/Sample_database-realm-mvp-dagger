package com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.globalDataProvider;

import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GlobalDataProvider {

    @GET("users/{user}/starred")
    Observable<List<GitHubRepo>> getStarredRepositories(@Path("user") String userName);

}
