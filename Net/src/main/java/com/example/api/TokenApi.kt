package com.example.api


import com.example.protocol.TokeReposEntity
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    fun getToken(
        @Field("grant_type")grant_type:String?,
        @Field("username") username:String?,
        @Field("password")password:String?
    ):retrofit2.Call<TokeReposEntity?>?

}