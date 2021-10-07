package com.shuke.usercenter.injection.module

import com.example.mvpcore.IModel
import com.shuke.usercenter.model.server.LoginModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

/**
 *
 */
@Module
class ModelModule {

    @IntoMap
    @StringKey("LoginModel")
    @Provides
    fun provideModel():IModel{
        return LoginModel()
    }
}