package com.example.search.good.injection

import com.example.di.component.ActivityComponent
import com.example.di.scope.InjectionScope
import com.example.search.good.GoodActivity
import dagger.Component

/**
@Name:yao
@CreateDate: 2021/9/27 16:26
@ProjectName: DS
@Package: com.example.search.good.injection
@ClassName: GoodComponet
 */
@InjectionScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(GoodsModule::class,ViewModule::class))
interface GoodComponet {
    fun injectgoodsComponent(activity: GoodActivity)
}