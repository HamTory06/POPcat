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
import java.net.URI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val tv = findViewById<TextView>(R.id.counts)
        val main = findViewById<ImageView>(R.id.cat)
        val request = PHP.api
//        val uri = Uri.parse("https://www.myinstants.com/media/sounds/pop-cat-original-meme_3ObdYkj.mp3")
//        var mediaplayer = MediaPlayer.create(this, uri)
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                main.setImageResource(R.drawable.opencat)
                Log.d("상태", "클릭")
            }
            MotionEvent.ACTION_UP -> {
                main.setImageResource(R.drawable.closecat)
//                mediaplayer?.start()
                Log.d("상태", "클릭해제")
                request.GetCounts().enqueue(object: Callback<POP>{
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
}