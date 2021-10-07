package com.example.sort.mvp.injection.module

import com.example.mvpcore.IModel
import com.example.sort.mvp.model.CarModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

/**
@CreateDate: 2021/9/23 16:18
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.injection.module
@ClassName: CarModule
 */
@Module
class CarModule {

    @IntoMap
    @StringKey("carModel")
    @Provides
    fun providesCarRemoteModel():IModel{
        return CarModel()
    }
}