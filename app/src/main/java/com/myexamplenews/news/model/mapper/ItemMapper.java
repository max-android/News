package com.myexamplenews.news.model.mapper;

import com.myexamplenews.news.model.database.entity.NewsDB;
import com.myexamplenews.news.model.pojo.Enclosure;
import com.myexamplenews.news.model.pojo.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 08.03.2018.
 */

public class ItemMapper {

    public static List<Item> transform(List<NewsDB> news) {

        List<Item> newList=new ArrayList<>();

        for(NewsDB newsDB:news){
            Enclosure enclosure=new Enclosure( newsDB.getUrl());
            newList.add(new Item(newsDB.getTitle(),newsDB.getDate(),enclosure,newsDB.getDescription()));
        }
        return newList;
    }
}
