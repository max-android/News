package com.myexamplenews.news.di.modules;

import android.support.annotation.NonNull;
import com.myexamplenews.news.model.database.AppBase;
import com.myexamplenews.news.model.service.NewsService;
import com.myexamplenews.news.presenter.NewsPresenter;
import com.myexamplenews.news.ui.general.NetInspector;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Максим on 14.03.2018.
 */
@Module
@Singleton
public class NewsPresenterModule {


    @Provides
    @Singleton
    public NewsPresenter provideNewsPresenter(@NonNull AppBase database, @NonNull NewsService newsService, @NonNull NetInspector netInspector){

        return  new  NewsPresenter(database,newsService,netInspector);

    }


}
