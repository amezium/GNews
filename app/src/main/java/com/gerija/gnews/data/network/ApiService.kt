package com.gerija.gnews.data.network

import com.gerija.gnews.data.network.model.JsonContainerDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("top-headlines?token=92d6df5cd190f39c53872c0f0cd74316")
    fun loadTopNews(
        @Query(QUERY_MAX_ARTICLES) max: Int = MAX_ARTICLES,
        @Query(QUERY_LANG) lang: String = LANG
    ): Single<JsonContainerDto>

    companion object{
        const val MAX_ARTICLES = 10
        const val QUERY_MAX_ARTICLES = "max"
        const val QUERY_LANG = "lang"
        const val LANG = "en"
    }
}