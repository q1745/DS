package com.example.net.retrofit;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * @Name:yao
 * @CreateDate: 2021/9/12 19:17
 * @ProjectName: DS
 * @Package: com.example.net.retrofit
 * @ClassName: CustomRequestBodyConverter
 */
public class CustomRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    @Nullable
    @Override
    public RequestBody convert(T value) throws IOException {
        String s = new Gson().toJson(value);
        return RequestBody.create(MEDIA_TYPE,s);
    }
}
