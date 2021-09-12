package com.example.net.retrofit;

import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.net.protocol.BaseRespEntity;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Name:yao
 * @CreateDate: 2021/9/11 10:50
 * @ProjectName: DS
 * @Package: com.example.net.retrofit
 * @ClassName: LiveDataCallAdapter
 */
public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<BaseRespEntity<R>>> {
    Type type;
    public LiveDataCallAdapter(Type t) {
        this.type= t;
    }

    @Override
    public Type responseType() {
        return type;
    }

    @Override
    public LiveData<BaseRespEntity<R>> adapt(Call<R> call) {
        MutableLiveData<BaseRespEntity<R>> liveData = new MutableLiveData<>();
        call.enqueue(new Callback<R>() {
            @Override
            public void onResponse(Call<R> call, Response<R> response) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    liveData.setValue((BaseRespEntity<R>) response.body());
                } else {
                    liveData.postValue((BaseRespEntity<R>) response.body());
                }
            }

            @Override
            public void onFailure(Call<R> call, Throwable t) {
                BaseRespEntity entity=new BaseRespEntity();
                entity.setCode(-11);
                entity.setMsg(t.getMessage());
                if (Looper.getMainLooper().getThread()==Thread.currentThread()){
                    liveData.setValue(entity);
                }else {
                    liveData.postValue(entity);
                }
            }
        });
        return liveData;
    }
}
