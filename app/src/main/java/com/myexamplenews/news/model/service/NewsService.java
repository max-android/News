package com.myexamplenews.news.model.service;

import com.myexamplenews.news.model.pojo.Rss;
import com.myexamplenews.news.ui.general.Constants;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Максим on 14.03.2018.
 */

public interface NewsService {

    @GET(Constants.REQUEST)
    Single<Rss> rss();

}
