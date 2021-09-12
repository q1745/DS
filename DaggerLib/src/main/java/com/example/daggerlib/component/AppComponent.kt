package com.example.daggerlib.component

import android.content.Context
import com.example.daggerlib.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Application 的 Component（桥梁）
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context():Context
}