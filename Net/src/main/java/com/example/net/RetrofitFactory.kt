package com.example.net

import com.example.api.TokenApi
import com.example.common.Config
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
@Name:yao
@CreateDate: 2021/9/15 20:19
@ProjectName: DS
@Package: com.example.net
@ClassName: RetrofitFactory
 */
class RetrofitFactory {
    companion object{
        val retrofitFactory:RetrofitFactory by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitFactory()
        }
    }
    /**
     * 创建retrofit实例
     * @return
     */
    val retrofit: Retrofit
    init {
        retrofit=Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(createOKHttpClient())
            .build()
    }
    /**
     * 创建OkHttp的client实例
     * @return
     */
    private fun createOKHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .readTimeout(Config.connectTime, TimeUnit.SECONDS)
            .writeTimeout(Config.connectTime,TimeUnit.SECONDS)
            .connectTimeout(Config.connectTime,TimeUnit.SECONDS)
            .addNetworkInterceptor(createLogInterce())
            .addInterceptor(createTokenInterceptor())
            .build()
    }

    private fun createTokenInterceptor(): Interceptor {
        val interceptor= Interceptor {
            var request=it.request()
            var response: Response?
            response=it.proceed(request)
            if (response.code()==401){
                val tokenApi: TokenApi =create(TokenApi::class.java)
                val token=tokenApi.getToken("password",Config.AUTHCODE,"")

                val result=token!!.execute()
                //拿到token
                val access =result.body()!!.access_token

                request=request.newBuilder()
                    .addHeader("Authorization","bearer $access")
                    .build()
                it.proceed(request)
            }else{
                response
            }

        }
        return interceptor
    }

    /**
     * 日志拦截器
     */
    private fun createLogInterce(): Interceptor {
        val logInterceptor= HttpLoggingInterceptor()
        logInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    /**
     * 获取api接口
     */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }
}