package com.example.mvpcore

import android.os.Build
import com.example.mvpcore.annotation.Model
import com.example.mvpcore.annotation.Presenter

abstract class BaseRepository {

    init {
        injectModel()
    }

    fun injectModel(){
        val javaClass = this.javaClass
        val declaredFields = javaClass.declaredFields
        if (declaredFields.size != 0){
            var hasModel : Boolean = false
            for (field in declaredFields){
                val annotation = field.getAnnotation(Model::class.java)
                if (annotation != null){
                    hasModel = true
                    field.isAccessible = true
                    var name : String = ""
                    if (Build.VERSION.SDK_INT >= 28){
                        name = field.genericType.typeName
                    }
                    else{
                        name = field.type.name
                    }
                    val forName = Class.forName(name)
                    val newInstance = forName.newInstance()
                    field.set(this,newInstance)
                }
            }
            if (!hasModel){
                throw IllegalAccessException("当前Repository没有Model")
            }
        }
        else{
            throw IllegalAccessException("当前Repository没有字段")
        }
    }

}