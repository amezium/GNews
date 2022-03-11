package com.gerija.gnews.repository

import com.gerija.gnews.model.network.dto.NewsContainerDto

interface NewsRepository {

    suspend fun loadTopNews(): Result<NewsContainerDto>

}