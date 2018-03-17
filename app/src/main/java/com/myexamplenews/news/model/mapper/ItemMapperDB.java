package com.myexamplenews.news.model.mapper;

import com.myexamplenews.news.model.database.entity.NewsDB;
import com.myexamplenews.news.model.pojo.Item;
import com.myexamplenews.news.ui.general.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 08.03.2018.
 */

public class ItemMapperDB {


    public static List<NewsDB> transform(List<Item> items){

        List<NewsDB> newList=new ArrayList<>();

        for(Item item:items){

        String url=" ";

            if(item.getEnclosure()==null){

                url=Constants.IMAGE;


            }else{

                url= item.getEnclosure().getUrl();
            }


            newList.add(new NewsDB(item.getTitle(),item.getPubDate(),url,item.getFulltext()));
        }
        return newList;
    }

}
