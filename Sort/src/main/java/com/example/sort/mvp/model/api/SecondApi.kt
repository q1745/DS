package com.example.sort.mvp.model.api

import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.model.entity.FirstRequestEntity
import com.example.sort.mvp.model.entity.SecondEntity
import com.example.sort.mvp.model.entity.SecondRequsetEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface SecondApi {

    @POST("category/getCategory")
    fun second(@Body a : SecondRequsetEntity): Observable<BaseReposEntity<SecondEntity>>
}