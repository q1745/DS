package com.example.goods.injection.module

import com.example.goods.ui.DetailView
import dagger.Module
import dagger.Provides

@Module
class ViewModule(val view:DetailView) {

    @Provides
    fun provideView() : DetailView{
        return view
    }
}