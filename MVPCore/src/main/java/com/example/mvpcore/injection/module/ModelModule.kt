package com.example.mvpcore.injection.module

import com.example.mvpcore.IModel
import dagger.Module
import dagger.Provides

@Module
class ModelModule(var model:IModel) {

    @Provides
    fun provideModel():IModel{
        return model
    }

}