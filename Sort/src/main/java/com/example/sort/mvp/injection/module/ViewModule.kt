package com.example.sort.mvp.injection.module

import com.example.sort.mvp.view.FirstView
import dagger.Module
import dagger.Provides


@Module
class ViewModule(var view:FirstView){

    @Provides
    fun provideView():FirstView{
        return view
    }
}