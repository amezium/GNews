package com.gerija.gnews

import android.content.Context
import com.gerija.gnews.model.database.NewsDatabase
import com.gerija.gnews.model.network.ApiFactory
import com.gerija.gnews.repository.GetTopNewsUseCase
import com.gerija.gnews.repository.loadDataApiInsertDbUseCase
import com.gerija.gnews.repository.NewsRepositoryImpl
import com.gerija.gnews.viewmodel.NewsViewModelFactory

class Component(val context: Context) {

    val newsDatabase = NewsDatabase.getInstance(context).newsDao()
    val apiService = ApiFactory.apiService
    val repository = NewsRepositoryImpl(newsDatabase,apiService)

    private fun getLoadDataUseCase(): loadDataApiInsertDbUseCase{
        return loadDataApiInsertDbUseCase(repository)
    }

    private fun getTopNewsUseCase(): GetTopNewsUseCase{
        return GetTopNewsUseCase(repository)
    }

    fun inject(factory: NewsViewModelFactory){
        factory.loadDataApiInsertDbUseCase = getLoadDataUseCase()
        factory.getTopNewsUseCase = getTopNewsUseCase()
    }
}