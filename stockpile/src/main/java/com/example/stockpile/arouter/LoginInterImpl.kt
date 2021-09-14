package com.example.stockpile.arouter

import android.content.Context
import android.media.MediaRouter
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.example.stockpile.Contrant
import com.example.stockpile.SPUtils


/**
@CreateDate: 2021/9/13 19:01
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.stockpile.arouter
@ClassName: LoginInterImpl
 */
class LoginInterImpl :IInterceptor {
    override fun init(context: Context?) {

    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val path = postcard!!.path
        var isBoolean = SPUtils.getBoolean(Contrant.SP_IS_LOGIN)
        if (isBoolean){
            callback?.onContinue(postcard)
        }else{
            when(path){

                else -> callback?.onContinue(postcard)
            }
        }
    }
}