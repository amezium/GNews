package com.gerija.gnews.data.network.model

import com.google.gson.annotations.SerializedName


data class JsonContainerDto(

    @SerializedName("articles") var articles: ArrayList<Articles> = arrayListOf()
)
