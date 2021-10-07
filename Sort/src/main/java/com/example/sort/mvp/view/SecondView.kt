package com.example.sort.mvp.view

import com.example.mvpcore.IView
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.model.entity.SecondEntity

interface SecondView : IView {
    fun secondSuccess(entity : BaseReposEntity<SecondEntity>)

    fun secondFailed(throwable: Throwable)
}