package com.example.saba.sample_database_realm_mvp_dager.app;

import android.app.Application;
import android.content.Context;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.globalDataProvider.GlobalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider.LocalDataProvider;
import com.example.saba.sample_database_realm_mvp_dager.domain.dataProviders.locadDataProvider.LocalDataProviderImpl;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.Repository;
import com.example.saba.sample_database_realm_mvp_dager.domain.repository.RepositoryImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.annotation.Nonnull;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.orhanobut.logger.Logger;

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract Context provideContext(@Nonnull final Application application);

    @Provides
    @Singleton
    static String provideBaseUrl(final Context context) {
        return context.getString(R.string.base_url);
    }

    @Provides
    @Singleton
    static Gson provideGson(){
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    static Converter.Factory provideGsonConverterFactory(@Nonnull final Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    static CallAdapter.Factory provideRx2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    static Interceptor provideLogInterceptor() {
        return new HttpLoggingInterceptor(Logger::d)
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(@Nonnull final Interceptor interceptor){
        return new OkHttpClient
                .Builder()
                .retryOnConnectionFailure(false)
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(@Nonnull final String baseUrl,
                             @Nonnull final OkHttpClient okHttpClient,
                             @Nonnull final Converter.Factory gsonConverterFactory,
                             @Nonnull final CallAdapter.Factory callAdapterFactory) {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

    @Provides
    @Singleton
    static GlobalDataProvider provideGlobalDataProvider(@Nonnull final Retrofit retrofit) {
        return retrofit.create(GlobalDataProvider.class);
    }

    @Provides
    @Singleton
    static LocalDataProvider provideLocalDataProvider(){
        return new LocalDataProviderImpl();
    }

    @Provides
    @Singleton
    static Repository provideRepository(@Nonnull final LocalDataProvider localDataProvider, @Nonnull final GlobalDataProvider globalDataProvider){
        return new RepositoryImpl(localDataProvider,globalDataProvider);
    }

}
