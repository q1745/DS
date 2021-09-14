package com.example.net.retrofit;

import androidx.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @Name:yao
 * @CreateDate: 2021/9/11 10:18
 * @ProjectName: DS
 * @Package: com.example.net
 * @ClassName: CustomGsonConverterFactory
 */
public class CustomGsonConverterFactory extends Converter.Factory {
    public static CustomGsonConverterFactory create() {
        return new CustomGsonConverterFactory();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new CustomResponseBodyConverter<>();
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new CustomRequestBodyConverter<>();
    }
}
