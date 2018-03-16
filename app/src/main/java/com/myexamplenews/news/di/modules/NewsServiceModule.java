package com.myexamplenews.news.di.modules;

import android.support.annotation.NonNull;

import com.myexamplenews.news.model.service.NewsService;
import com.myexamplenews.news.ui.general.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Максим on 14.03.2018.
 */
@Module
@Singleton
public class NewsServiceModule {


    @Provides
    @Singleton
    public Retrofit provideRetrofit(){


        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }


    @Provides
    @Singleton
    public NewsService provideNewsService(@NonNull Retrofit retrofit){

        return retrofit.create(NewsService.class);
    }

}
