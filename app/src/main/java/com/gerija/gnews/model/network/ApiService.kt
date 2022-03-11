package com.gerija.gnews.model.network


import com.gerija.gnews.model.network.dto.NewsContainerDto
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("top-headlines?token=92d6df5cd190f39c53872c0f0cd74316")
    suspend fun loadTopNews(
        @Query(QUERY_MAX_ARTICLES) max: String = MAX_ARTICLES,
        @Query(QUERY_LANG) lang: String = LANG
    ): NewsContainerDto



    companion object{
        const val MAX_ARTICLES = "20"
        const val QUERY_MAX_ARTICLES = "max"
        const val QUERY_LANG = "lang"
        const val LANG = "en"
    }
}