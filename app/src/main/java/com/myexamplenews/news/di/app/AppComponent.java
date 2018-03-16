package com.myexamplenews.news.di.app;

import com.myexamplenews.news.di.modules.DatabaseModule;
import com.myexamplenews.news.di.modules.GlideModule;
import com.myexamplenews.news.di.modules.NetInspectorModule;
import com.myexamplenews.news.di.modules.NewsPresenterModule;
import com.myexamplenews.news.di.modules.NewsServiceModule;
import com.myexamplenews.news.ui.screen.DetailFragment;
import com.myexamplenews.news.ui.screen.NewsFragment;
import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component(modules = {
        NewsServiceModule.class,
        NewsPresenterModule.class,
         GlideModule.class,
        DatabaseModule.class,
        NetInspectorModule.class
})

 public interface AppComponent {

     void injectNewsFragment(NewsFragment newsFragment);
     void injectDetailFragment(DetailFragment detailFragment);
}
