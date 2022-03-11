package com.gerija.gnews.model.network.dto

import com.google.gson.annotations.SerializedName


data class NewsContainerDto(
    @SerializedName("totalArticles") var totalArticles: Int? = null,
    @SerializedName("articles") var articles: ArrayList<Articles> = arrayListOf()
)
