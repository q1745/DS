package com.example.sort.mvp.injection.component

import androidx.core.app.ActivityCompat
import com.example.di.component.ActivityComponent
import com.example.di.module.ActivityModule
import com.example.di.scope.InjectionScope
import com.example.sort.mvp.injection.module.CarModule
import com.example.sort.mvp.injection.module.CarViewModule
import com.example.sort.mvp.view.CarFramgent
import dagger.Component

/**
@CreateDate: 2021/9/23 16:15
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.injection.component
@ClassName: CarComponent
 */
@InjectionScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CarModule::class,CarViewModule::class))
interface CarComponent {
    fun getCarFramgent(fragment:CarFramgent)
}