package com.example.goods.injection.module

import com.example.goods.service.model.DetailModel
import com.example.mvpcore.IModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class ModelModule {

    @IntoMap
    @StringKey("remoteModel")
    @Provides
    fun provideModel():IModel{
        return DetailModel()
    }

}