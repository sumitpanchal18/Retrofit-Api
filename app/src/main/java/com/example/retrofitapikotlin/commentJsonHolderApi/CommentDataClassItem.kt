package com.example.retrofitapikotlin.commentJsonHolderApi

data class CommentDataClassItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)