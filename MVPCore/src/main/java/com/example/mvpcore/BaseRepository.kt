package com.example.mvpcore

import javax.inject.Inject

abstract class BaseRepository {

    @Inject
    protected lateinit var models:MutableMap<String,IModel>

}