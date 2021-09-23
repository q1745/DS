package com.example.goods.injection.component

import com.example.di.component.ActivityComponent
import com.example.di.scope.InjectionScope
import com.example.goods.injection.module.ModelModule
import com.example.goods.injection.module.ViewModule
import com.example.goods.ui.fragment.GoodsDetailOne
import dagger.Component

@InjectionScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ModelModule::class,ViewModule::class))
interface DetailComponent {

    fun injectFragment(fragment:GoodsDetailOne)

}