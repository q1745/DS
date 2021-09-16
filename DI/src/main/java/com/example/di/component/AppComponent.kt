package com.example.di.component

import android.content.Context
import com.example.di.BaseApp
import com.example.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context():Context
}