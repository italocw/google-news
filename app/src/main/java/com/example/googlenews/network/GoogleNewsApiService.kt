package com.example.googlenews.network

import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "a9d6a121757548bdb04d482df5e32d18"
private const val TOP_HEADLINES_ENDPOINT = "top-headlines?sources=google-news-br&apiKey=".plus(
    API_KEY
)

val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .build()

interface GoogleNewsApiService {
    @GET(TOP_HEADLINES_ENDPOINT)
    fun getTopHeadlines(): Call<NewsRequestResponse>
}

object GoogleNewsApi {
    val retrofitService: GoogleNewsApiService by lazy { retrofit.create(GoogleNewsApiService::class.java) }
}
