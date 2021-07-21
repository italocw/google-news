package com.example.googlenews

import java.util.*

data class News(
    val title: String,
    val imageUrl: String,
    val url: String,
    val details: String,
    val author: String,
    val publishedAt: Date,
    val content: String
)
