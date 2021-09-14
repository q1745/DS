package com.example.common.router.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

@Interceptor(priority = 1,name = "isLoginInterceptor")
class IsLoginInterceptor : IInterceptor {

    var mContext:Context ?= null

    override fun init(context: Context?) {
        mContext = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {

    }
}