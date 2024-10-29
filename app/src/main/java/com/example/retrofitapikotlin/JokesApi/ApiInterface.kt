package com.example.retrofitapikotlin.JokesApi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("jokes/random")
    fun getJokes():Call<sumit>
}