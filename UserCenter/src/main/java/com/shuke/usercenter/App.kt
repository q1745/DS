package com.shuke.usercenter

import com.alibaba.android.arouter.launcher.ARouter
import com.example.di.BaseApp

class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
    }
}