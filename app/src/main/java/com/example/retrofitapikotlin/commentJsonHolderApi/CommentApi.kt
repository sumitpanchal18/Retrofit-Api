package com.example.retrofitapikotlin.commentJsonHolderApi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentApi {
    @GET("comments")
    suspend fun getComments(
        @Query("id") id: Int
    ): Response<List<CommentDataClassItem>>
}