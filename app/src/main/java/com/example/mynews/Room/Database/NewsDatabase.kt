package com.example.mynews.Room.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynews.Room.Dao.NewsDao
import com.example.mynews.Room.Entity.NewsFavourite

@Database(entities = [NewsFavourite::class], version = 1, exportSchema = false)
abstract class NewsDatabase: RoomDatabase() {
    abstract val NewsDao:NewsDao
    companion object {
        @Volatile
        private var INSTANCE:NewsDatabase? = null
        fun getDatabase(context:Context):NewsDatabase?{
            if (INSTANCE==null){
                synchronized(
                    NewsDatabase::class.java
                ){
                    if (INSTANCE==null){
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            NewsDatabase::class.java,
                            "NewsDatabase"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }

}