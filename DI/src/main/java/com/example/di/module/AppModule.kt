package com.example.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var application: Application) {

    @Singleton
    @Provides
    fun provideContext():Context{
        return application
    }
}