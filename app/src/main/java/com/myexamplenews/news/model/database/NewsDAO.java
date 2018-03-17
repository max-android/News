package com.myexamplenews.news.model.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.myexamplenews.news.model.database.entity.NewsDB;
import java.util.List;
import io.reactivex.Single;

/**
 * Created by Максим on 14.03.2018.
 */

@Dao
public interface NewsDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
   public void insertNews(List<NewsDB> news);


    @Query("DELETE FROM newstable")
    public void deleteNews();

    @Query("SELECT * FROM newstable")
    Single<List<NewsDB>> getNews();


    @Query("SELECT * FROM newstable")
    public List<NewsDB> getList();

}
