package tun.kt.data.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Component
import tun.kt.data.datasource.*
import tun.kt.data.local.dao.ImageDAO
import tun.kt.data.network.API

@DataScope
@Component(modules = [NetworkModule::class, LocalModule::class, DataSourceModule::class])
interface DataComponent {
    fun inject(context: Context)
    val sharePreference: SharedPreferences
    val sharedPreferencesDataSource: SharePreferencesDataSource
    val api: API
    val markerDataSource: MarkerDataSource
    val imageLocalDataSource: ImageLocalDataSource
    val imageNetworkDataSource: ImageNetworkDataSource
    val paintDataSource: PaintDataSource
    val imageDAO: ImageDAO

    @Component.Builder
    interface Builder {
        fun build(): DataComponent
        fun roomDBModule(localModule: LocalModule): Builder
        fun dataSourceModule(dataSourceModule: DataSourceModule): Builder
    }
}