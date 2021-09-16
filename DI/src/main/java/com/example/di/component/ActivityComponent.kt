package com.example.di.component

import android.app.Activity
import android.content.Context
import com.example.di.module.ActivityModule
import com.example.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun context():Context
    fun activity():Activity
}