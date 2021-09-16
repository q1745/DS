package com.example.sort.mvp.injection.component

import com.example.di.component.ActivityComponent
import com.example.di.scope.InjectionScope
import com.example.sort.MainActivity
import com.example.sort.mvp.injection.module.ViewModule
import com.example.sort.mvp.view.SortFragment
import dagger.Component

@InjectionScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ViewModule::class))
interface SortComponent {
    fun injectMainActivity(fragment:SortFragment)
}