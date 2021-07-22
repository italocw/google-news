package com.example.googlenews.network

import com.squareup.moshi.Json
import retrofit2.http.Path
import java.util.*

data class News(
    val title: String,
    @Json(name = "urlToImage") val imageUrl: String,
    val url: String,
    val details: String,
    val author: String,
    val publishedAt: Date,
    val content: String)
