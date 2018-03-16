package com.myexamplenews.news.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.myexamplenews.news.model.database.AppBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Максим on 14.03.2018.
 */

@Module
@Singleton
public class DatabaseModule {

    private Context context;


    public DatabaseModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    public AppBase provideDatabase(){

        return   Room.databaseBuilder(context,AppBase.class, "dbnews").build();
    }
}