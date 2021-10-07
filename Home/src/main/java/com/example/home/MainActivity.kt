package com.example.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.home.common.HOME_BANNER_FOUR
import com.example.home.common.HOME_BANNER_ONE
import com.example.home.common.HOME_BANNER_THREE
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //绘制布局前换位原来的布局样式
        setTheme(R.style.Theme_DS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}