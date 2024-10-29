package com.example.retrofitapikotlin.commentJsonHolderApi

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapikotlin.databinding.ActivityCommentApiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = 18

        val apiCall = CommentApiClient.api.getComments(id)
        Log.d(TAG, "onCreate: ")

        apiCall.enqueue(object : Callback<List<CommentDataClassItem>?> {
            override fun onResponse(
                call: Call<List<CommentDataClassItem>?>,
                response: Response<List<CommentDataClassItem>?>
            ) {
                val res = response.body()
                Log.d(TAG, "onResponse: $res")
                binding.progressBar.visibility = View.GONE
                res?.forEach {
                    Log.d(TAG, "Email : ${it.email}")
                    Log.d(TAG, "Name : ${it.name}")
                }
            }

            override fun onFailure(call: Call<List<CommentDataClassItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}