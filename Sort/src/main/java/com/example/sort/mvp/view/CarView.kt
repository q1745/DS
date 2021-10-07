package com.example.sort.mvp.view

import com.example.mvpcore.IView
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.CarEntity

/**
@CreateDate: 2021/9/23 15:53
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.view
@ClassName: CarView
 */
interface CarView:IView {
    fun success(entity:BaseReposEntity<CarEntity>)
    fun failed(throwable: Throwable)
}