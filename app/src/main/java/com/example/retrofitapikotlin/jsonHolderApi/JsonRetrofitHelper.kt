package com.example.retrofitapikotlin.jsonHolderApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JsonRetrofitHelper {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: JsonApiService by lazy {
        JsonRetrofitHelper.retrofit.create(JsonApiService::class.java)
    }
}