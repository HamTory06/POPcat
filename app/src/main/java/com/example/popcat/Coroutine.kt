package com.example.popcat

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import okhttp3.Dispatcher

class Coroutine : AppCompatActivity(){

    var mediaplayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun a(){
        CoroutineScope(Dispatchers.Main).async {
            val sound = CoroutineScope(Dispatchers.Default).async {
                mediaplayer = MediaPlayer.create(this@Coroutine, R.raw.popcat_sound)
                mediaplayer!!.start() // 소리 재생
                mediaplayer!!.setOnCompletionListener {
                    it.stop()
                }
            }.await()
            val
        }//메인 스레드
    }
    fun Retrofit(){

    }
}