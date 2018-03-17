package com.myexamplenews.news.presenter;

import android.util.Log;

import com.myexamplenews.news.model.database.AppBase;
import com.myexamplenews.news.model.mapper.ItemMapper;
import com.myexamplenews.news.model.mapper.ItemMapperDB;
import com.myexamplenews.news.model.service.NewsService;
import com.myexamplenews.news.ui.general.NetInspector;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Максим on 14.03.2018.
 */

public class NewsPresenter implements Presenter {


    @Inject
    AppBase database;

    @Inject
    NewsService newsService;

    @Inject
    NetInspector netInspector;


    private CompositeDisposable subscrition = new CompositeDisposable();


    public NewsPresenter(AppBase database, NewsService newsService, NetInspector netInspector) {
        this.database = database;
        this.newsService = newsService;
        this.netInspector = netInspector;
    }

    @Override
    public void attach(NewsView view) {

        if(netInspector.isOnline()){

            Log.d("Online","Online");
            subscrition.add(newsService.rss()
                    .doOnError(error -> Log.d("ERROR",error.getMessage()))
                    .doOnSuccess(rss -> {

                        if(!database.getNewsDAO().getList().isEmpty()) {
                            database.getNewsDAO().deleteNews();
                        }
                        database.getNewsDAO().insertNews(ItemMapperDB.transform(rss.getChannel().getItem()));

                    })
                            .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe (rss -> view.showNews(rss.getChannel().getItem())
                            ,error -> view.showErrorLoadingNews()));
                           // ,error -> Log.d("ERROR",error.getMessage())));

        }else{

            subscrition.add(database.getNewsDAO().getNews()
                    .doOnSuccess(list-> {
                        Log.d("SIZE_DB",  String.valueOf(database.getNewsDAO().getList().size()));
                    })
                            .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(newsDBS -> view.showNews(ItemMapper.transform(newsDBS))
                            ,error ->view.showErrorLoadingNews()));
        }

    }

    @Override
    public void detach() {

        subscrition.clear();

    }
}
