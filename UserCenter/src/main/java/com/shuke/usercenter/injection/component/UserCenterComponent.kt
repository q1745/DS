package com.shuke.usercenter.injection.component

import com.example.di.component.ActivityComponent
import com.example.di.scope.InjectionScope
import com.shuke.usercenter.injection.module.ModelModule
import com.shuke.usercenter.injection.module.ViewModule
import com.shuke.usercenter.view.LoginActivity
import dagger.Component


@InjectionScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ModelModule::class,ViewModule::class))
interface UserCenterComponent {

    fun inject(activity:LoginActivity)
}