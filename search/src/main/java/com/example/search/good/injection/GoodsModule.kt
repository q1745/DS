package com.example.search.good.injection

import com.example.mvpcore.IModel
import com.example.search.good.model.GoodsModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

/**
@Name:yao
@CreateDate: 2021/9/27 16:27
@ProjectName: DS
@Package: com.example.search.good.injection
@ClassName: GoodsModule
 */
@Module
class GoodsModule {
    @IntoMap
    @StringKey("goodsmodel")
    @Provides
    fun providesFirstRemoteModel(): IModel {
        return GoodsModel()
    }
}