package com.example.di

import android.app.Application
import android.content.Context
import com.example.di.component.AppComponent
import com.example.di.component.DaggerAppComponent
import com.example.di.module.AppModule

abstract class BaseApp : Application(){
    var daggerAppComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        context = this
        initInjection()
    }

    private fun initInjection() {
        daggerAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

    companion object{
        lateinit var context: Context
    }


}