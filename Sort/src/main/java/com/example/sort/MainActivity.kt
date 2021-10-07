package com.example.sort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //绘制布局前换位原来的布局样式
        setTheme(R.style.Theme_DS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}