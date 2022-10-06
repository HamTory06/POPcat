package com.example.popcat

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PHP {
    companion object{
        private const val url = "https://jsonplaceholder.typicode.com"
        private var server:Retrofit= Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var pop:POP = server.create(POP::class.java)
    }
}