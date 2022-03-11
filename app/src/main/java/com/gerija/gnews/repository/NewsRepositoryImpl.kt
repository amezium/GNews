package com.gerija.gnews.repository

import com.gerija.gnews.model.network.ApiFactory
import com.gerija.gnews.model.network.dto.NewsContainerDto


class NewsRepositoryImpl: NewsRepository {

    override suspend fun loadTopNews(): Result<NewsContainerDto> {
        return Result.success(ApiFactory.apiService.loadTopNews())
    }
}