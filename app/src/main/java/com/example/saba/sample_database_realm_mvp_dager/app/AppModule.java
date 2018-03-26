package com.example.saba.sample_database_realm_mvp_dager.app;


import android.app.Application;
import android.content.Context;

import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.LocalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.LocalDataProviderImpl;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.RepositoryImpl;

import javax.annotation.Nonnull;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract Context provideContext(@Nonnull final Application application);

    @Provides
    @Singleton
    static LocalDataProvider provideLocalDataProvider(){
        return new LocalDataProviderImpl();
    }

    @Provides
    @Singleton
    static Repository provideRepository(LocalDataProvider localDataProvider){
        return new RepositoryImpl(localDataProvider);
    }

}
