package com.example.search.good.repository

import com.example.mvpcore.BaseRepository
import com.example.protocol.BaseReposEntity
import com.example.search.good.model.GoodsModel
import com.example.search.good.model.entity.GoodsEntity
import io.reactivex.Observer
import javax.inject.Inject

/**
@Name:yao
@CreateDate: 2021/9/27 11:14
@ProjectName: DS
@Package: com.example.search.good.repository
@ClassName: GoodsRepository
 */
class GoodsRepository @Inject constructor() :BaseRepository() {
    fun getGood(categoryId: Int, pageNo: Int, observer: Observer<BaseReposEntity<GoodsEntity>>){
        (models.get("goodsmodel") as GoodsModel).getgoods(categoryId,pageNo,observer)
    }
}