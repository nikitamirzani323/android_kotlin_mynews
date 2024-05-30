package com.example.mynews.Room.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mynews.Room.Entity.NewsFavourite
import com.example.mynews.Room.Repositry.NewsRepositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(application: Application):AndroidViewModel(application) {
    private val NewsRepositry:NewsRepositry = NewsRepositry(application)
    fun getAllNews():LiveData<List<NewsFavourite>> = NewsRepositry.getAllNews()
    fun deleteNews(url:String) = viewModelScope.launch(Dispatchers.IO) {
        NewsRepositry.deleteNews(url)
    }
    fun InsertNews(newsFavourite: NewsFavourite) = viewModelScope.launch(Dispatchers.IO) {
        NewsRepositry.insertNews(newsFavourite)
    }
}