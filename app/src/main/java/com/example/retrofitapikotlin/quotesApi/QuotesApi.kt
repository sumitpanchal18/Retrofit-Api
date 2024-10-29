package com.example.retrofitapikotlin.quotesApi

import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi{

    @GET("quotes")
    fun getQuotes() : Response<DataClassQuotes>
}