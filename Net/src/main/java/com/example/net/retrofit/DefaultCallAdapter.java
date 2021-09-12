package com.example.net.retrofit;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * @Name:yao
 * @CreateDate: 2021/9/11 10:59
 * @ProjectName: DS
 * @Package: com.example.net.retrofit
 * @ClassName: DefaultCallAdapter
 */
public class DefaultCallAdapter<R> implements CallAdapter<R, Object> {
    Type type;

    public DefaultCallAdapter(Type t) {
        this.type=t;
    }

    @Override
    public Type responseType() {
        return type;
    }

    @Override
    public Object adapt(Call<R> call) {
        return call;
    }
}
