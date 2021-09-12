package com.example.mvpcore.common

import android.app.Activity
import java.util.*

class ActivityManager private constructor(){

    /**
     * 管理Activity的栈
     */
    private val activityStack:Stack<Activity> = Stack()

    /**
     * 懒汉单例，lazy默认同步锁
     */
    companion object{
        val instance:ActivityManager by lazy { ActivityManager() }
    }


    /**
     * 进栈
     */
    fun addActivity(activity:Activity){
        activityStack.add(activity)
    }

    /**
     * 出栈
     */
    fun finishActivity(activity:Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 清空栈
     */
    fun removeAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }

    /**
     * 获取当前栈顶
     */
    fun currentActivity(): Activity? {
        return activityStack.lastElement()
    }

}