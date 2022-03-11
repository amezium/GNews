package com.gerija.gnews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gerija.gnews.model.database.NewsDatabase
import com.gerija.gnews.model.network.dto.Articles
import com.gerija.gnews.repository.NewsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsViewModel(application: Application): AndroidViewModel(application) {

    private val repository = NewsRepositoryImpl()
    private val newsDatabase = NewsDatabase.getInstance(application).newsDao()
    private val getNews = MutableLiveData<List<Articles>>()
    val _getNews: LiveData<List<Articles>> get() = getNews


    init {
        viewModelScope.launch {
            repository.getTopNewsApi().onSuccess { newsDatabase.insertDataBase(it.articles)}
            launch(Dispatchers.IO) { getNews.postValue(newsDatabase.getTopNews()) }
        }
    }
}