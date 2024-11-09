package com.example.retrofitapikotlin.http

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapikotlin.R
import com.example.retrofitapikotlin.databinding.ActivityHttpBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HttpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHttpBinding

    private lateinit var textViewResponse: TextView
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHttpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewResponse = findViewById(R.id.textViewResponse)
        fetchUserData()
    }

    private fun fetchUserData() {
        val url = "https://jsonplaceholder.typicode.com/users"

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    textViewResponse.text = "Error: ${e.message}"
                }
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val responseData = response.body?.string()
                    runOnUiThread {
                        textViewResponse.text = responseData
                    }
                }
            }
        })
    }
}
