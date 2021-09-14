package com.example.mvpcore.view

import android.os.Build
import com.example.mvpcore.annotation.Presenter

/**
 * 基于MVP框架的Activity的基类
 * 利用注解+反射实现对应多个Presenter
 */
abstract class BaseMVPActivity : BaseActivity(){

    init {
        innjectPresenter()
    }

    fun innjectPresenter(){
        val javaClass = this.javaClass
        val declaredFields = javaClass.declaredFields
        if (declaredFields.size != 0){
            var hasPresenter : Boolean = false
            for (field in declaredFields){
                val annotation = field.getAnnotation(Presenter::class.java)
                if (annotation != null){
                    hasPresenter = true
                    field.isAccessible = true
                    var name : String = ""
                    if (Build.VERSION.SDK_INT >= 28){
                        name = field.genericType.typeName
                    }
                    else{
                        name = field.type.name
                    }
                    val forName = Class.forName(name)
                    val newInstance = forName.declaredConstructors.get(0).newInstance(this)
                    field.set(this,newInstance)
                }
            }
            if (!hasPresenter){
                throw IllegalAccessException("当前Activity没有Presenter")
            }
        }
        else{
            throw IllegalAccessException("当前View没有字段")
        }
    }
}