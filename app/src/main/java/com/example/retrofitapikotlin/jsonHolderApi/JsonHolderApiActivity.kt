package com.example.retrofitapikotlin.jsonHolderApi

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapikotlin.databinding.ActivityJsonHolderApiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JsonHolderApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityJsonHolderApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonHolderApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val postId = 6
            val call = ApiClient.apiService.getPostById(postId)

            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("please wait")
            progressDialog.show()

            call.enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    if (response.isSuccessful) {
                        val post = response.body()
                        Log.d(TAG, "onResponse: ${post?.title}")
                        binding.txtTitle.text = response.body()?.body
                        progressDialog.dismiss()
                    } else {
                        Log.d(TAG, "onResponse: ERROR")
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Log.d(TAG, "onResponse: ERROR")
                }
            })
        }
    }
}