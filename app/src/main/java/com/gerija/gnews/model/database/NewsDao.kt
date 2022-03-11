package com.gerija.gnews.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gerija.gnews.model.network.dto.Articles


@Dao
interface NewsDao {

    @Query("SELECT * FROM all_news")
    fun getTopNews(): LiveData<List<Articles>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataBase(articles: List<Articles>)
}