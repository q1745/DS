package com.example.sort.mvp.injection.module

import com.example.mvpcore.IModel
import com.example.sort.mvp.model.FirstModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
class FirstModule {

    @IntoMap
    @StringKey("remoteModel")
    @Provides
    fun providesFirstRemoteModel():IModel{
        return FirstModel()
    }

    @IntoMap
    @StringKey("localmodel")
    @Provides
    fun providesFirstlocalModel():IModel{
        return FirstModel()
    }
}