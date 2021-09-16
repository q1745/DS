package com.example.ds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.util.utils.Base64Util
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val aa = Base64Util.encodeBase64("isLoginisTrue")
                Log.i("TAG", "加密结果: ${aa}")
                val bb = Base64Util.decodeBase64(aa)
                Log.i("TAG", "解密结果: ${bb}")
            }
        })
    }
}