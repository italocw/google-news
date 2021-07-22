package com.example.googlenews.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "a9d6a121757548bdb04d482df5e32d18"
private const val TOP_HEADLINES_ENDPOINT = "top-headlines?sources=google-news-br&apiKey=".plus(
    API_KEY
)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GoogleNewsApiService {
    @GET(TOP_HEADLINES_ENDPOINT)
    fun getTopHeadlines(): Call<String>
}

object GoogleNewsApi {
    val retrofitService: GoogleNewsApiService by lazy { retrofit.create(GoogleNewsApiService::class.java) }
}