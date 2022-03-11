package com.gerija.gnews.model.network.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "all_news")
data class Articles(

    @PrimaryKey(autoGenerate = true) val key: Int,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("content") var content: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("url") var url: String? = null,
): Serializable