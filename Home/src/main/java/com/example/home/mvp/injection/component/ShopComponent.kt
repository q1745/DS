package com.example.home.mvp.injection.component

import com.example.di.component.ActivityComponent
import com.example.di.scope.InjectionScope
import com.example.home.HomeFragment
import com.example.home.mvp.injection.module.ShopModule
import com.example.home.mvp.injection.module.ViewModule
import dagger.Component

@InjectionScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ShopModule::class, ViewModule::class))
interface ShopComponent {
    fun injectShopComponent(fragment: HomeFragment)
}