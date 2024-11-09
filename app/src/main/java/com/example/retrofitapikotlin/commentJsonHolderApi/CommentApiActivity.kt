package com.example.retrofitapikotlin.commentJsonHolderApi

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapikotlin.databinding.ActivityCommentApiBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            val apiCall = CommentApiClient.api.getComments()
            binding.progressBar.visibility = View.GONE
            try {
                if (apiCall.isSuccessful) {
                    val result = apiCall.body()
                    Log.d(TAG, "Api result : $result")
                    result?.forEach {
                        Log.d(TAG, "Name : ${it.name}")
                    }
                } else {
                    Log.e(TAG, "onCreate: else part")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error catch")
            }

        }
    }
}
