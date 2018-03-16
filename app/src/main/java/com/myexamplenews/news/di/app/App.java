package com.myexamplenews.news.di.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.myexamplenews.news.di.modules.DatabaseModule;
import com.myexamplenews.news.di.modules.GlideModule;
import com.myexamplenews.news.di.modules.NetInspectorModule;
import com.myexamplenews.news.di.modules.NewsPresenterModule;
import com.myexamplenews.news.di.modules.NewsServiceModule;


public class App extends Application {


    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .newsServiceModule(new NewsServiceModule())
                .newsPresenterModule(new NewsPresenterModule())
                .glideModule(new GlideModule(this))
                .databaseModule(new DatabaseModule(this))
                .netInspectorModule(new NetInspectorModule(this))
                .build();
    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        MultiDex.install(this);
    }

}
