package com.example.stockpile

import android.content.Context
import android.content.SharedPreferences

/**
@Name:yao
@CreateDate: 2021/9/11 8:07
@ProjectName: DS
@Package: com.example.stockpile
@ClassName: SPUtils
 */
object SPUtils {
    private var sp:SharedPreferences=MyApp.context.getSharedPreferences("sq",Context.MODE_PRIVATE)
    private var ed: SharedPreferences.Editor

    init {
        ed= sp.edit()
    }
    /**
     * Boolran数据
     */
    fun putBoolean(key:String,value:Boolean){
        ed.putBoolean(key,value)
        ed.commit()
    }

    /**
     * 默认为false
     */
    fun getBoolean(key:String):Boolean{
        return sp.getBoolean(key,false)
    }
    /**
     * String数据
     */
    fun putStirng(key:String,value: String){
        ed.putString(key,value)
        ed.commit()
    }


    /**
     * 默认为 “”
     */
    fun getString(key:String):String? {
        return sp.getString(key,"")
    }

    /**
     * Int数据
     */
    fun putInt(key:String,value: Int){
        ed.putInt(key,value)
        ed.commit()
    }

    /**
     * 默认为0
     */
    fun getInt(key:String):Int{
        return sp.getInt(key,0)
    }
    /**
     * 删除
     */

    fun remove(key:String){
        ed.remove(key)
        ed.commit()
    }


}