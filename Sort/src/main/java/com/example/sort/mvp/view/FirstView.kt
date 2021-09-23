package com.example.sort.mvp.view

import com.example.mvpcore.IView
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.FirstEntity

interface FirstView : IView {

    fun success(entity : BaseReposEntity<FirstEntity>)

    fun failed(throwable: Throwable)
}