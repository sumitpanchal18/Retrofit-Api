package com.example.retrofitapikotlin.quotesApi

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapikotlin.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuotesApiActivity : AppCompatActivity(){
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_quotes_api)

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            Log.d(TAG, "Api Response : " + result.body().toString())
        }
    }
}