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
                mediaplayer = MediaPlayer.create(this, R.raw.popact_sound)
                Log.d("소리상태", mediaplayer.toString())
                mediaplayer!!.start()
                mediaplayer!!.setOnCompletionListener {
                    it.stop()
                }
                Log.d("상태", "클릭")
            }
            MotionEvent.ACTION_UP -> {
                main.setImageResource(R.drawable.closecat)
                mediaplayer?.release ()
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

    override fun onDestroy() {
        super.onDestroy()
    }
}