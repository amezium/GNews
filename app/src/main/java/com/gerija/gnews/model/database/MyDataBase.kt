package com.gerija.gnews.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gerija.gnews.model.network.dto.Articles


@Database(entities = [Articles::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    companion object {

        private var db: NewsDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): NewsDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, NewsDatabase::class.java, DB_NAME).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun newsDao(): NewsDao
}