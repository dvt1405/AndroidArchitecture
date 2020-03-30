package tun.kt.data.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tun.kt.apilib.apihistory.CustomInterceptor
import tun.kt.data.Constant
import tun.kt.data.network.API
import tun.kt.data.network.APIControl

@Module
@Suppress("unused")
class NetworkModule {

    @Provides
    @DataScope
    fun provideRxAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @DataScope
    fun provideOKHttpClient(interceptor: CustomInterceptor) = OkHttpClient.Builder().build()

    @Provides
    @Reusable
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_API)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @Reusable
    fun provideAPI(retrofit: Retrofit): API = APIControl.getInstance()
        .buildRetrofit(Constant.BASE_API)


}