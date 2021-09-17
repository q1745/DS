package com.example.sort.mvp.model.api

import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.model.entity.FirstRequestEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface FirstApi {

    @POST("category/getCategory")
    fun sortList(@Body a : FirstRequestEntity):Observable<BaseReposEntity<FirstEntity>>
}