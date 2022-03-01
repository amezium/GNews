package com.gerija.gnews.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "all_link")
data class Articles (

    @PrimaryKey(autoGenerate = true) val key: Int,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("content"     ) var content     : String? = null,
    @SerializedName("url"         ) var url         : String? = null,
    @SerializedName("image"       ) var image       : String? = null,
    @SerializedName("publishedAt" ) var publishedAt : String? = null,
)