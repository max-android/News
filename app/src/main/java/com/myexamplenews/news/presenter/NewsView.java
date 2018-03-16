package com.myexamplenews.news.presenter;

import com.myexamplenews.news.model.pojo.Item;

import java.util.List;

/**
 * Created by Максим on 14.03.2018.
 */

public interface NewsView {


    void showNews(List<Item> results);
    void showErrorLoadingNews();



}
