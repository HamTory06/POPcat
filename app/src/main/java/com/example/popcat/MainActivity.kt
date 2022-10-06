package com.example.popcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val request = PHP.pop.POP(id)
        request.enqueue(object: Callback<POP>{
            override fun onResponse(call: Call<POP>, response: Response<POP>) { todo.value = response.body()
                Log.d("RESPONSE", "Response: ${response.code()}")
            }
            override fun onFailure(call: Call<POP>, t: Throwable) {

            }
        })
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val main = findViewById<ImageView>(R.id.main)
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                main.setImageResource(R.drawable.opencat)
                Log.d("상태", "클릭")

            }
            MotionEvent.ACTION_UP -> {
                main.setImageResource(R.drawable.closecat)
                Log.d("상태", "클릭해제")
            }
            else -> Log.d("상태","무")
        }
        return super.onTouchEvent(event)
    }
}