package com.example.mvpcore.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.mvpcore.R
import com.example.mvpcore.common.ActivityManager
import java.nio.file.Files.find

/**
 * Activity基类
 */
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

    /**
     * 销毁方法出栈
     */
    override fun onDestroy() {
        super.onDestroy()
        ActivityManager.instance.finishActivity(this)
    }

    /**
     * 展示消息
     */
    fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    /**
     * 获取根视图
     */
    val contentView:View
    get() {
        return (this.findViewById(android.R.id.content) as ViewGroup).getChildAt(0)
    }
}