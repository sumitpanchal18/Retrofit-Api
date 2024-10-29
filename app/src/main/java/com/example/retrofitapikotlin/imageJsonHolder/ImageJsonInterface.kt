package com.example.retrofitapikotlin.imageJsonHolder

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageJsonInterface {

    @GET("photos")
    fun getPhotos(@Query("id") id : Int) : Call<List<ImageJsonDataClassItem>>
}