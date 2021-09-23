package com.example.ds

import com.example.Bbody
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST


interface Api {

    @POST("http://39.98.153.96:8088/shopapi/category/getCategory")
    fun getList(@Body a : Bbody):Observable<Bean>
}