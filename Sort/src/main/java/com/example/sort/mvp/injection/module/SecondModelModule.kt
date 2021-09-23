package com.example.sort.mvp.injection.module

import com.example.mvpcore.IModel
import com.example.sort.mvp.model.FirstModel
import com.example.sort.mvp.model.SecondModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class SecondModelModule {

    @IntoMap
    @StringKey("SecondremoteModel")
    @Provides
    fun providesFirstRemoteModel(): IModel {
        return SecondModel()
    }
}