package com.example.mvpcore

import javax.inject.Inject

abstract class BaseRepository<M : IModel> {

    @Inject
    protected lateinit var model:M

}