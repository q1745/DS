package com.example.daggerlib.module

import android.content.Context
import com.example.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Application的Module
 * 单例
 */
@Module
class AppModule(private val context: BaseApplication) {

    @Singleton
    @Provides
    fun provideContext():Context{
        return this.context
    }
}