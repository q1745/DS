package com.example.common.utils

import android.util.Log

/**
@CreateDate: 2021/9/10 20:14
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.common
@ClassName: LogUtil
 */
class LogUtil {
    companion object{
        private val LOGV = true
        private val LOGD = true
        private val LOGI = true
        private val LOGW = true
        private val LOGE = true
        fun v(tag: String?, msg: String?) {
            if (LOGV) {
                Log.v(tag, msg!!)
            }
        }

        fun d(tag: String?, msg: String?) {
            if (LOGD) {
                Log.d(tag, msg!!)
            }
        }

        fun i(tag: String?, msg: String?) {
            if (LOGI) {
                Log.i(tag, msg!!)
            }
        }

        fun w(tag: String?, msg: String?) {
            if (LOGW) {
                Log.w(tag, msg!!)
            }
        }

        fun e(tag: String?, msg: String?) {
            if (LOGE) {
                Log.e(tag, msg!!)
            }
        }
    }
}