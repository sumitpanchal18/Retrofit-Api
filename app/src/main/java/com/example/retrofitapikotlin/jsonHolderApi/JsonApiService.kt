package com.example.retrofitapikotlin.jsonHolderApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonApiService {
    @GET("posts/{id}")

    fun getPostById(@Path("id") post: Int) : Call<Post>
//    fun getPostById(@Path("id") postId : Int) : Call<Post>
}