package com.example.retrofitapikotlin.imageJsonHolder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ImageRetrofitHelper {
    val baseUrl = "https://jsonplaceholder.typicode.com"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ImageApiClient {
    val imageApiService: ImageJsonInterface by lazy {
        ImageRetrofitHelper.retrofit.create(ImageJsonInterface::class.java)
    }
}