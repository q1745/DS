package com.example.net.api;

import com.example.net.protocol.TokenRespEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Name:yao
 * @CreateDate: 2021/9/11 11:08
 * @ProjectName: DS
 * @Package: com.example.net.api
 * @ClassName: TokenApi
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntity> getToken(@Field("grant_type") String grant_type, @Field("username") String username, @Field("password") String password);
}
