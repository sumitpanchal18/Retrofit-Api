package com.example.retrofitapikotlin.imageJsonHolder

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofitapikotlin.R
import com.example.retrofitapikotlin.databinding.ActivityImageJsonHolderBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageJsonHolderActivity : AppCompatActivity() {
    lateinit var binding: ActivityImageJsonHolderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageJsonHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiCall = ImageApiClient.imageApiService.getPhotos(1)

        apiCall.enqueue(object : Callback<List<ImageJsonDataClassItem>?> {
            override fun onResponse(
                call: Call<List<ImageJsonDataClassItem>?>,
                response: Response<List<ImageJsonDataClassItem>?>
            ) {
                val res = response.body()


                Log.d(TAG, "onResponse: $res")
                res?.forEach { imageItem ->

                    Log.d(TAG, "Image Url : ${imageItem.url}")

                    /*Glide.with(this@ImageJsonHolderActivity)
                        .load("https://cdn-icons-png.flaticon.com/128/8297/8297164.png")
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background)
                        .into(binding.imgApi)
                    */
                    Log.d(TAG, "onResponse title : ${imageItem.title}")
                }
            }

            override fun onFailure(call: Call<List<ImageJsonDataClassItem>?>, t: Throwable) {
                Log.d(TAG, "onFailure: Api response Failed")
            }
        })

    }

}