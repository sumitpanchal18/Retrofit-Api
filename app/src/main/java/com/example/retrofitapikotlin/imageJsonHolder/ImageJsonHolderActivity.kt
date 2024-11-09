package com.example.retrofitapikotlin.imageJsonHolder

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofitapikotlin.R
import com.example.retrofitapikotlin.databinding.ActivityImageJsonHolderBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageJsonHolderActivity : AppCompatActivity() {
    lateinit var binding: ActivityImageJsonHolderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageJsonHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = 1

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val apiCall = ImageApiClient.imageApiService.getPhotos(id)
                if (apiCall.isSuccessful) {
                    val response = apiCall.body()
                    Log.d(TAG, "Api Response : $response")
                    response?.forEach {
                        Log.d(TAG, "Image Url : ${it.url}")
                        Log.d(TAG, "Title : ${it.title}")
                    }
                } else {
                    Log.e(TAG, "Response not successful")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception : $e")
            }
        }
    }

}