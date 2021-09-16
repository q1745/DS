package com.example.mvpcore.injection.module

import com.example.mvpcore.IModel
import com.example.mvpcore.IView
import dagger.Module
import dagger.Provides

@Module
class ViewModule(var view:IView) {

    @Provides
    fun provideModel():IView{
        return view
    }
}