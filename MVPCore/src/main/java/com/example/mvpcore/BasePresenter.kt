package com.example.mvpcore

import javax.inject.Inject

abstract class BasePresenter<V : IView,R : BaseRepository<*>>(_view:V) {

    @Inject
    protected lateinit var mView:V

    @Inject
    protected lateinit var mRepository:R

}