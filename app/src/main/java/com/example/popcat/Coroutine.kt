package com.example.popcat

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent.ACTION_DOWN
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Coroutine : AppCompatActivity(){

    var mediaplayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        CoroutineScope(Dispatchers.Main).async {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    CoroutineScope(Dispatchers.Default).async {

                    }
                }
                MotionEvent.ACTION_UP -> {
                    CoroutineScope(Dispatchers.Default).async {

                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }
}