package com.example.retrofitapikotlin.imageJsonHolder

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageJsonInterface {

    @GET("photos")
    suspend fun getPhotos(
        @Query("id") id: Int
    ): Response<List<ImageJsonDataClassItem>>
}