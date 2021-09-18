package com.example.ds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.TextView
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

/**
 * 引导页
 */
class WelcomeActivity : AppCompatActivity() {

    lateinit var wel_tv: TextView
    var i: Int = 5
    var handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        init();

        //延迟一秒发送
        handler.postDelayed(object : Runnable {
            override fun run() {
                //延迟一秒发送自身
                handler.postDelayed(this,1000)
                i--
                runOnUiThread {
                    wel_tv.text = "倒计时:" + i + "秒"
                }
                if (i==0){
                    startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                }
            }
        },1000L)
    }

    private fun init() {
        wel_tv = findViewById<TextView>(R.id.wel_tv)
    }
}