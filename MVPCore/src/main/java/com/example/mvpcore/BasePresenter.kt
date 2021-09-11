package com.example.mvpcore

abstract class BasePresenter<V : IView,R : BaseRepository>(_view:V) {

    protected lateinit var mView:V
    protected lateinit var mRepository:R

    init {
        mView = _view
        mRepository = createRepostory()
    }

    abstract fun createRepostory(): R
}