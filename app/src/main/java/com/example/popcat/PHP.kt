package com.example.popcat

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PHP {
    companion object{
        private const val url = "http://10.80.162.219:8010"
        private var server:Retrofit= Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api:API = server.create(API::class.java)
    }
}