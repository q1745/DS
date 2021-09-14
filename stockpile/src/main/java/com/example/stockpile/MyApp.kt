package com.example.stockpile

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

/**
@Name:yao
@CreateDate: 2021/9/11 8:07
@ProjectName: DS
@Package: com.example.stockpile
@ClassName: MyApp
 */
open class MyApp :Application(){
    lateinit var appComponent: Application
    override fun onCreate() {
        super.onCreate()
        context=this
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.getInstance().inject(this)
    }

    companion object{
        lateinit var context: Context
    }
}