package com.example.ds

import android.Manifest
import com.example.mvpcore.view.BaseActivity

import android.util.Log
import com.alibaba.sdk.android.cloudcode.SplashAdView

import com.alibaba.sdk.android.cloudcode.AdLoadListener

import com.alibaba.sdk.android.cloudcode.SplashAdView.SplashAdInteractListener
import android.content.Intent





class SplashActivity : BaseActivity(){

    private var isClickAd = false
    override fun initEvent() {

    }

    override fun initData() {
        val splashAdView = findViewById<SplashAdView>(R.id.splashAdView)
        // 设置广告加载监听
        // 设置广告加载监听
        splashAdView.setAdLoadListener(object : AdLoadListener {
            override fun loadSuccess() {
                Log.i("TAG", "广告加载成功")
            }

            override fun loadFail(s: String, s1: String) {
                Log.i("TAG", "$s $s1")
            }
        })

        // 设置广告交互监听

        // 设置广告交互监听
        splashAdView.setAdInteractListener(object : SplashAdInteractListener {
            override fun onTimeOver() {
                Log.i("TAG", "倒计时结束")
                goToMain()
            }

            override fun jump() {
                Log.i("TAG", "用户点击跳过")
                goToMain()
            }

            override fun onShowed() {
                Log.i("TAG", "广告曝光")
            }

            override fun onClicked() {
                Log.i("TAG", "广告点击")
                isClickAd = true
            }

            override fun onAction(i: Int, i1: Int) {
                Log.i("TAG", "广告效果 $i $i1")
            }
        })

        // 请求加载广告

        // 请求加载广告
        splashAdView.loadAd()
    }

    override fun initView() {

    }

    override fun getLayoutId(): Int {
        return R.layout.splash_activity
    }
    override fun onStart() {
        super.onStart()
        if (isClickAd) {
            // 从广告界面返回的
            goToMain()
        }
    }

    private fun goToMain() {
        // 开屏广告展示结束，跳转主界面
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }

}