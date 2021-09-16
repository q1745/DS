package com.example.sort.mvp.injection.module

import com.example.sort.mvp.view.SortView
import dagger.Module
import dagger.Provides


@Module
class ViewModule(var view:SortView){

    @Provides
    fun provideView():SortView{
        return view
    }
}