package com.example.di

import android.app.Application
import com.example.di.component.AppComponent
import com.example.di.component.DaggerAppComponent
import com.example.di.module.AppModule

abstract class BaseApp : Application(){
    var daggerAppComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    private fun initInjection() {
        daggerAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }


}