package com.gerija.gnews.data.network.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gerija.gnews.data.network.model.Articles

@Database(entities = [Articles::class], version = 2, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    companion object {

        private var db: MyDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): MyDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        MyDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun newsDao(): NewsDao
}