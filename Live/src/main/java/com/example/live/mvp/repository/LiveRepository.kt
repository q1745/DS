package com.example.live.mvp.repository

import com.example.live.mvp.model.LiveModel
import com.example.live.mvp.model.entity.LiveEntity
import com.example.mvpcore.BaseRepository
import com.example.protocol.BaseReposEntity
import io.reactivex.Observer
import javax.inject.Inject

/**
@CreateDate: 2021/9/26 8:36
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.live.mvp.repository
@ClassName: LiveRepository
 */
class LiveRepository @Inject constructor():BaseRepository() {
    fun success(observer: Observer<BaseReposEntity<LiveEntity>>){
        (models.get("") as LiveModel).getLiveList(observer)
    }
}