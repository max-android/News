package com.myexamplenews.news.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.myexamplenews.news.model.database.entity.NewsDB;

/**
 * Created by Максим on 14.03.2018.
 */


@Database(entities = {NewsDB.class}, version = 1)
public abstract class AppBase extends RoomDatabase {

    public abstract NewsDAO getNewsDAO();

}