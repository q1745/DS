package com.example.sort.mvp.model.api

import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.entity.CarEntity
import com.example.sort.mvp.model.entity.FirstEntity
import com.example.sort.mvp.model.entity.FirstRequestEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
@CreateDate: 2021/9/23 16:28
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.model.api
@ClassName: CarApi
 */
interface CarApi {
    @POST("cart/getList")
    fun carList(): Observable<BaseReposEntity<CarEntity>>
}