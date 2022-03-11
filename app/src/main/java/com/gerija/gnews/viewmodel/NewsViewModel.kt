package com.gerija.gnews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gerija.gnews.model.database.NewsDatabase
import com.gerija.gnews.model.database.NewsDatabase_Impl
import com.gerija.gnews.model.network.dto.NewsContainerDto
import com.gerija.gnews.repository.NewsRepositoryImpl
import kotlinx.coroutines.launch


class NewsViewModel(application: Application): AndroidViewModel(application) {

    private val repository = NewsRepositoryImpl()
    private val newsDatabase = NewsDatabase.getInstance(application).newsDao()
    private val getNews = MutableLiveData<NewsContainerDto>()
    val _getNews: LiveData<NewsContainerDto> get() = getNews


//    private val db = MyDatabase.getInstance(application).newsDao()
//    val getTopNews = db.getTopNews()

//
//    fun loadData(){
//        //db.insertDataBase(it.articles)
//        ApiFactory.apiService.loadTopNews()
//    }

    init {
        viewModelScope.launch {
            repository.loadTopNews().onSuccess { getNews.value = it }
        }
    }
}