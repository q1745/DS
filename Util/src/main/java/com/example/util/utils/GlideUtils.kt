package com.example.util.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object GlideUtils {

    /**
     * 正常加载
     */
    fun loadImage(context:Context,url:String,view:ImageView){
        Glide.with(context).load(url).into(view)
    }

    /**
     * 加载图片设置圆形
     */
    fun loadCircleImage(context: Context,url: String,view: ImageView){
        Glide.with(context).load(url).circleCrop().into(view)
    }

}