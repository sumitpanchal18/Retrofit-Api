package com.example.retrofitapikotlin.JokesApi

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCall {

    fun getJokes(context: Context,callback:(sumit)->Unit){
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service : ApiInterface = retrofit.create(ApiInterface::class.java)

        
        val call : Call<sumit> = service.getJokes()


        call.enqueue(object :Callback<sumit>{
            override fun onResponse(
                call: Call<sumit>,
                response: Response<sumit>
            ) {
                if (response.isSuccessful)
                {
                    val jokes : sumit = response.body() as sumit
                    callback(jokes)
                }
            }

            override fun onFailure(call: Call<sumit>, t: Throwable) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
