package com.example.saba.sample_database_realm_mvp_dager.app;


import android.app.Application;
import android.content.Context;
import javax.annotation.Nonnull;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract Context provideContext(@Nonnull final Application application);

}
