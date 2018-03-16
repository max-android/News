package com.myexamplenews.news.presenter;

/**
 * Created by Максим on 14.03.2018.
 */

public interface Presenter {

    //экран создан
    void attach(NewsView view);
    //экран уничтожается
    void detach();


}
