package com.example.goods.injection.module

import com.example.goods.ui.DetailView
import com.example.goods.ui.fragment.GoodsDetailOne
import dagger.Module
import dagger.Provides

@Module
class ViewModule(var view:GoodsDetailOne) {

    @Provides
    fun provideView() : GoodsDetailOne{
        return view
    }
}