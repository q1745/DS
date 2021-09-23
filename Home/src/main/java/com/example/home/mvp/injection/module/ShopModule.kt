package com.example.home.mvp.injection.module

import com.example.home.mvp.model.ShopModel
import com.example.mvpcore.IModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class ShopModule {

    @IntoMap
    @StringKey("remoteModel")
    @Provides
    fun providesFirstRemoteModel(): IModel {
        return ShopModel()
    }
}