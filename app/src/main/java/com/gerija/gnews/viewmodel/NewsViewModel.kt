package com.gerija.gnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gerija.gnews.model.network.dto.Articles
import com.gerija.gnews.repository.GetTopNewsUseCase
import com.gerija.gnews.repository.loadDataApiInsertDbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsViewModel(
    private val loadDataApiInsertDbUseCase: loadDataApiInsertDbUseCase,
    private val getTopNewsUseCase: GetTopNewsUseCase) : ViewModel() {

    private val getNews = MutableLiveData<List<Articles>>()
    val _getNews: LiveData<List<Articles>> get() = getNews

    init {
        viewModelScope.launch {
            loadDataApiInsertDbUseCase()

            launch(Dispatchers.IO) {
                getNews.postValue(getTopNewsUseCase())
            }
        }
    }
}