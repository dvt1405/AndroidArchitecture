package tun.kt.data.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import tun.kt.data.Constant
import tun.kt.data.local.DB

@Suppress("unused")
@Module
class LocalModule(var context: Context) {
    var db: DB = DB.getDatabase(context)

    @Provides
    @DataScope
    fun providesLocalDB(): DB = db

    @Provides
    @DataScope
    fun providesImageDao() = db.imageDAO()

    @Provides
    @DataScope
    fun providesMarkerDao() = db.markerDAO()

    @Provides
    @DataScope
    fun providesImageMarkerDao() = db.imageMarkerDAO()

    @Provides
    @DataScope
    fun providesPaintDao() = db.paintDAO()

    @Provides
    @DataScope
    fun providesSharedPreferences(): SharedPreferences =
        context.getSharedPreferences(Constant.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
}