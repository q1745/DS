package com.example.sort.mvp.view

import com.example.mvpcore.IView

interface SortView : IView {

    fun success(msg : String)

    fun failed(throwable: Throwable)
}