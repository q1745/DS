package com.example.util.utils

import android.util.Base64


/**
 * Base64加密工具
 */
object Base64Util {

    /**
     * Base64加密
     */
    fun encodeBase64(data:String) : String{
        return Base64.encodeToString(data.toByteArray(charset("UTF-8")),1)
    }

    /**
     * Base64解密
     */
    fun decodeBase64(data: String):String{
        return String(Base64.decode(data.toByteArray(charset("UTF-8")),1))
    }
}