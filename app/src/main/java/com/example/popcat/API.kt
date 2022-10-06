package com.example.popcat

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET


interface API {
    @GET("1")
    fun counts(): Call<POP>
}