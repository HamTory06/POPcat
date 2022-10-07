package com.example.popcat

import retrofit2.Call
import retrofit2.http.GET


interface API {
    @GET("1")
    fun GetCounts(): Call<POP>
}

