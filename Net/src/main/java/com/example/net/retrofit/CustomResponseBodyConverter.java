package com.example.net.retrofit;

import com.example.net.protocol.BaseRespEntity;
import com.example.net.protocol.TokenRespEntity;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @Name:yao
 * @CreateDate: 2021/9/11 10:21
 * @ProjectName: DS
 * @Package: com.example.net.retrofit
 * @ClassName: CustomResponseBodyConverter
 */
public class CustomResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    @Override
    public T convert(ResponseBody value) throws IOException {
        String s = value.toString();
        if (s.contains("access_")){
            return (T) new Gson().fromJson(s, TokenRespEntity.class);
        }
        BaseRespEntity baseRespEntity = new Gson().fromJson(s, BaseRespEntity.class);
        return (T) baseRespEntity;
    }
}
