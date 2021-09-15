package com.example.common.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.common.BaseApplication
import com.example.common.BaseConstant
import java.lang.ClassCastException

/**
 * 单例SP工具类
 * 封装commit以及apply提交方式
 */
object SpUtil {

    private val sp : SharedPreferences = BaseApplication.context.getSharedPreferences(
        BaseConstant.SP_TABLENAME,
        Context.MODE_PRIVATE
    )
    private var edit : SharedPreferences.Editor
    init {
        edit = sp.edit()
    }


    //commit方式提交
    fun put(key:String,value:Any){
        when(value){
            is String -> edit.putString(key,value)
            is Int -> edit.putInt(key,value)
            is Long -> edit.putLong(key,value)
            is Boolean -> edit.putBoolean(key,value)
            is Float -> edit.putFloat(key,value)
            else -> throw ClassCastException("SpUtil的put方法类型转换失败")
        }
        edit.commit()
    }

    //apply方式提交,链式调用
    fun applyPut(key:String,value:Any):SharedPreferences.Editor{
        when(value){
            is String -> edit.putString(key,value)
            is Int -> edit.putInt(key,value)
            is Long -> edit.putLong(key,value)
            is Boolean -> edit.putBoolean(key,value)
            is Float -> edit.putFloat(key,value)
            else -> throw ClassCastException("SpUtil的put方法类型转换失败")
        }
        return edit
    }

    //apply提交
    fun toApply(){
        edit.apply()
    }

    /**
     * 根据key取值
     */
//    fun <T> get(key:String,default:T):T{
//        when(default){
//            is String -> sp.getString(key,default)
//            is Int -> sp.getInt(key,default)
//            is Long -> sp.getLong(key,default)
//            is Boolean -> sp.getBoolean(key,default)
//            is Float -> sp.getFloat(key,default)
//            else -> throw IllegalAccessException("检查SpUtil所给入口参数是否有误")
//        }
//        return default
//    }
    /**
     * 取String值  默认“”
     */
    fun getStirng(key:String): String? {
        return sp.getString(key,"")
    }

    /**
     * 取Int值  默认0
     */
    fun getInt(key:String):Int?{
        return sp.getInt(key,0)
    }

    /**
     * 取Boolean值  默认false
     */
    fun getBoolean(key : String):Boolean{
        return sp.getBoolean(key,false)
    }

    /**
     * 取Long值  默认0
     */
    fun getLong(key : String) : Long{
        return sp.getLong(key,0)
    }

    /**
     * 取Float值  默认0F
     */
    fun getFloat(key : String) : Float{
        return sp.getFloat(key,0F)
    }

    /**
     * 存放Set集合
     */
    fun putStringSet(key : String,value:MutableSet<String>){
        val stringSet = getStringSet(key)
        if (stringSet != null){
            stringSet.addAll(value)
        }
        edit.putStringSet(key,value)
        edit.commit()
    }

    /**
     * 取StringSet集合  默认空的Set集合
     */
    fun getStringSet(key : String) : MutableSet<String>? {
        var set : MutableSet<String> = mutableSetOf()
        return sp.getStringSet(key,set)
    }

    /**
     * 根据Key删除数据
     */
    fun remove(key : String){
        edit.remove(key)
    }
}