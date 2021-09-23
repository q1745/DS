package com.example.di.module

import android.app.Activity
import com.example.di.scope.ActivityScope
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(var activity: Activity) {

    @ActivityScope
    @Provides
    fun provideContext():Activity{
        return activity
    }
}