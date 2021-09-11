package com.example.mvpcore.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpcore.common.ActivityManager

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        addActivity()
        if (IsClearBar()){
            ClearBar()
        }
        initView()
        initData()
        initEvent()
    }

    fun addActivity(){
        ActivityManager.instance.addActivity(this)
    }

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 出事化控件
     */
    abstract fun initView()

    /**
     * 沉浸式布局
     */
    fun ClearBar(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT
    }

    /**
     * 是否实现沉浸式
     * 默认实现
     */
    fun IsClearBar(): Boolean{
        return true
    }

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * Activity跳转
     */
    fun jumpActivity(clazz: Class<AppCompatActivity>){
        startActivity(Intent(this@BaseActivity,clazz))
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityManager.instance.finishActivity(this)
    }
}