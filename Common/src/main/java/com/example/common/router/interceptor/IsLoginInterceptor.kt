package com.example.common.router.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.example.common.BaseConstant
import com.example.common.router.RouterPath
import com.example.common.utils.Base64Util
import com.example.common.utils.SpUtil

@Interceptor(priority = 1,name = "isLoginInterceptor")
class IsLoginInterceptor : IInterceptor {

    var mContext:Context ?= null

    override fun init(context: Context?) {
        mContext = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val isLogin : String? = SpUtil.getStirng("isLogin")
        val decodeBase64 = isLogin?.let { Base64Util.decodeBase64(it) }
        if (decodeBase64!!.equals(BaseConstant.SP_ISLOGIN)){
            callback!!.onContinue(postcard)
        }

    }
}