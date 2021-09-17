package com.example.mvpcore

import javax.inject.Inject

abstract class BasePresenter<V : IView,R : BaseRepository>() {

    @Inject
    protected lateinit var view:V

    @Inject
    protected lateinit var repository:R

}