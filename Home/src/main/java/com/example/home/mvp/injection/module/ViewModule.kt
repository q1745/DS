package com.example.home.mvp.injection.module

import com.example.home.mvp.view.ShopView
import dagger.Module
import dagger.Provides

@Module
class ViewModule (var view: ShopView){

    @Provides
    fun provideView():ShopView{
        return view
    }
}