package com.gerija.gnews.repository

import com.gerija.gnews.model.network.dto.Articles

interface NewsRepository {

    suspend fun loadDataApiInsertDb()

    fun getTopNews(): List<Articles>

}
