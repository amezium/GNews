package com.gerija.gnews.data.network.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gerija.gnews.data.network.model.Articles
import com.gerija.gnews.data.network.model.JsonContainerDto


@Dao
interface NewsDao {

    @Query("SELECT * FROM all_link")
    fun getTopNews(): LiveData<List<Articles>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataBase(articles: ArrayList<Articles>)
}