package com.example.search.good.injection

import com.example.search.good.view.GoodsView
import dagger.Module
import dagger.Provides

/**
@Name:yao
@CreateDate: 2021/9/27 16:27
@ProjectName: DS
@Package: com.example.search.good.injection
@ClassName: ViewModule
 */
@Module
class ViewModule(var view:GoodsView) {
    @Provides
    fun provideView():GoodsView{
        return view
    }

}