package com.example.retrofitapikotlin.JokesApi

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapikotlin.databinding.ActivityMainBinding

class JokesMain : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoke.setOnClickListener {
            binding.idLoadingPB.visibility = View.VISIBLE
            binding.tvJoke.visibility = View.GONE

            ApiCall().getJokes(this@JokesMain) { jokes ->
                Log.d(TAG, "onCreate: $jokes")
                binding.tvJoke.text = jokes.value
                binding.tvId.text = jokes.id
                binding.tvUrl.text =jokes.url
                binding.tvCaAt.text =jokes.created_at

                binding.idLoadingPB.visibility = View.GONE
                binding.tvJoke.visibility = View.VISIBLE
            }
        }
    }
}