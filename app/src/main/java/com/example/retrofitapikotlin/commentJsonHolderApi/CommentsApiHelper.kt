package com.example.retrofitapikotlin.commentJsonHolderApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CommentsApiHelper {

    private val baseUrl = "https://jsonplaceholder.typicode.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

object CommentApiClient {
    val api: CommentApi by lazy {
        CommentsApiHelper.retrofit.create(CommentApi::class.java)
    }
}