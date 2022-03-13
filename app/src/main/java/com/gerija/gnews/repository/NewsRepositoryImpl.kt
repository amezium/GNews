package com.gerija.gnews.repository

import com.gerija.gnews.model.database.NewsDao
import com.gerija.gnews.model.network.ApiFactory
import com.gerija.gnews.model.network.ApiService
import com.gerija.gnews.model.network.dto.Articles
import com.gerija.gnews.model.network.dto.NewsContainerDto


class NewsRepositoryImpl(private val newsDao: NewsDao, private val apiService: ApiService)
    : NewsRepository {

    override suspend fun loadDataApiInsertDb() {
        newsDao.insertDataBase(apiService.loadTopNews().articles)
    }

    override fun getTopNews(): List<Articles> {
        return newsDao.getTopNews()
    }
}
