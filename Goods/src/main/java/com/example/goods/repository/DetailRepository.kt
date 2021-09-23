package com.example.goods.repository

import com.example.goods.service.entity.GoodsDetailEntity
import com.example.goods.service.model.DetailModel
import com.example.mvpcore.BaseRepository
import com.example.protocol.BaseReposDataEntity
import com.example.protocol.BaseReposEntity
import io.reactivex.Observer
import javax.inject.Inject

class DetailRepository @Inject constructor()  : BaseRepository() {

    fun getGoodsDetail(goodsId:Int,observer: Observer<BaseReposDataEntity<GoodsDetailEntity>>){
        (models.get("remoteModel") as DetailModel).getGoodsDetail(goodsId,observer)
    }
}