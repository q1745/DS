package com.example.sort.mvp.injection.component

import com.example.di.component.ActivityComponent
import com.example.di.scope.InjectionScope
import com.example.sort.mvp.injection.module.FirstModule
import com.example.sort.mvp.injection.module.ViewModule
import com.example.sort.mvp.view.FirstFragment
import dagger.Component

@InjectionScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ViewModule::class,FirstModule::class))
interface SortComponent {
    fun injectSortFragment(fragment:FirstFragment)
}