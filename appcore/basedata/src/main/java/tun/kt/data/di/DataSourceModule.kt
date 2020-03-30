package tun.kt.data.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import tun.kt.data.datasource.*
import tun.kt.data.local.dao.ImageDAO
import tun.kt.data.local.dao.ImageMarkerDAO
import tun.kt.data.local.dao.MarkerDAO
import tun.kt.data.local.dao.PaintDAO
import tun.kt.data.local.datasource.ImageLocalDataSourceImpl
import tun.kt.data.local.datasource.MarkerDataSourceImpl
import tun.kt.data.local.datasource.PaintDataSourceImpl
import tun.kt.data.local.storage.SharedPreferencesDataSourceImpl
import tun.kt.data.network.API
import tun.kt.data.network.datasource.ImageNetworkDataSourceImpl

@Module
class DataSourceModule {

    @DataScope
    @Provides
    fun markerDataSource(markerDAO: MarkerDAO): MarkerDataSource = MarkerDataSourceImpl(markerDAO)

    @Provides
    fun sharedPreferenceDataSource(sharedPreferences: SharedPreferences?): SharePreferencesDataSource =
        SharedPreferencesDataSourceImpl(sharedPreferences)

    @DataScope
    @Provides
    fun imageLocalDataSource(
        imageDAO: ImageDAO,
        imageMarkerDAO: ImageMarkerDAO
    ): ImageLocalDataSource = ImageLocalDataSourceImpl(imageDAO, imageMarkerDAO)

    @DataScope
    @Provides
    fun imageNetworkDataSource(api: API, imageDAO: ImageDAO): ImageNetworkDataSource = ImageNetworkDataSourceImpl(api, imageDAO)

    @DataScope
    @Provides
    fun paintDataSource(paintDAO: PaintDAO): PaintDataSource = PaintDataSourceImpl(paintDAO)

}