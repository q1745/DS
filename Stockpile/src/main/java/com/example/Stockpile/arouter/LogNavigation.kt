package com.example.stockpile.arouter

import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter

/**
@CreateDate: 2021/9/13 19:58
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.Stockpile.arouter
@ClassName: LogNavigation
 */
class LogNavigation : NavigationCallback {
    override fun onFound(postcard: Postcard?) {

    }

    override fun onLost(postcard: Postcard?) {

    }

    override fun onArrival(postcard: Postcard?) {

    }

    override fun onInterrupt(postcard: Postcard?) {
        var path = postcard!!.path
        var extras :Bundle = postcard!!.extras
        ARouter.getInstance().build("")
            .with(extras)
            .withString("",path)//第一个放地址
            .navigation()
    }
}