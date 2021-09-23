package com.example.home.mvp.repository

import com.example.home.mvp.model.ShopModel
import com.example.home.mvp.model.entity.ShopEntity
import com.example.mvpcore.BaseRepository
import com.example.protocol.BaseReposEntity
import io.reactivex.Observer
import javax.inject.Inject

class ShopRepository @Inject constructor() : BaseRepository() {

    fun getShop(categoryId: Int, pageNo: Int, observer: Observer<BaseReposEntity<ShopEntity>>){
        (models.get("remoteModel") as ShopModel).getShop(categoryId, pageNo, observer)
    }
}