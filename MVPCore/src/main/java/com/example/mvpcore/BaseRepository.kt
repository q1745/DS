package com.example.mvpcore

import android.os.Build
import com.example.mvpcore.annotation.Model
import com.example.mvpcore.annotation.Presenter
import javax.inject.Inject

abstract class BaseRepository<M : IModel> {

    @Inject
    protected lateinit var model:M

}