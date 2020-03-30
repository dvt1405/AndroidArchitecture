package tun.kt.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tun.kt.apilib.apihistory.CustomInterceptor
import java.util.concurrent.TimeUnit

class APIControl constructor() {
    fun buildRetrofit(url: String): API {
        val interceptor = CustomInterceptor()
        interceptor.level = CustomInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(url)
            .build()
            .create(API::class.java)
    }

    companion object {
        private var INSTANCE: APIControl? = null
        fun getInstance(): APIControl {
            return INSTANCE ?: APIControl()
        }
    }
}