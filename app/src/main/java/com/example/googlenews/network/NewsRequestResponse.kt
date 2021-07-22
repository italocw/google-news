package com.example.googlenews.network

import com.squareup.moshi.Json

data class NewsRequestResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<News>
)
