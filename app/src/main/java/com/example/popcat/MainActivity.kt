package com.example.popcat

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.*
import java.net.URI

class MainActivity : AppCompatActivity() {

    var mediaplayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val tv = findViewById<TextView>(R.id.counts)
        val main = findViewById<ImageView>(R.id.cat)
        val request = PHP.api
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                main.setImageResource(R.drawable.opencat)
                Log.d("소리상태", mediaplayer.toString())
                mediaplayer = MediaPlayer.create(this, R.raw.popcat_sound)
                mediaplayer!!.start() // 소리 재생
                mediaplayer!!.setOnCompletionListener {
                    it.stop() // 소리 중지
                }
                Log.d("상태", "클릭")
            }
            MotionEvent.ACTION_UP -> {
                main.setImageResource(R.drawable.closecat) // 사진 변경
                mediaplayer?.release ()
                Log.d("상태", "클릭해제")
                request.GetCounts().enqueue(object: Callback<POP>{ //레트로핏 서버 연결
                    override fun onResponse(call: Call<POP>, response: Response<POP>) {
                        Log.d("상태", "성공")
                        tv.text = "${response.body()?.counts}"
                    }
                    override fun onFailure(call: Call<POP>, t: Throwable) {
                        Log.d("상태","오류(서버)")
                        Log.d("상태",t.message.toString())
                    }
                })
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}