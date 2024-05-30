package com.example.mynews.Room.Repositry

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mynews.Room.Dao.NewsDao
import com.example.mynews.Room.Database.NewsDatabase
import com.example.mynews.Room.Entity.NewsFavourite

class NewsRepositry(application: Application) {
    private val NewsDb:NewsDatabase = application.let {
        NewsDatabase.getDatabase(application)!!
    }
    val dao:NewsDao = NewsDb.NewsDao
    fun getAllNews():LiveData<List<NewsFavourite>>{
        return dao.getAllNews()
    }
    suspend fun deleteNews(url:String){
        dao.deleteNews(url)
    }
    suspend fun insertNews(newsFavourite: NewsFavourite){
        dao.insertNews(newsFavourite)
    }
}