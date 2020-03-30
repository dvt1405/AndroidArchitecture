package tun.kt.usecase.di

import android.content.Context
import androidx.lifecycle.LiveData
import dagger.Module
import dagger.Provides
import tun.kt.data.DataState
import tun.kt.data.model.Image
import tun.kt.data.model.Marker
import tun.kt.usecase.repository.ImageRepository
import tun.kt.usecase.repository.MarkerRepository
import tun.kt.usecase.usecase.GetImage
import tun.kt.usecase.usecase.GetMarker
import tun.kt.usecase.usecase.UseCase
import javax.inject.Inject
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @UseCaseScope
    fun providesGetImage(imageRepository: ImageRepository): UseCase<DataState<Image>> =
        GetImage(imageRepository)

    @Provides
    @UseCaseScope
    fun providesGetMarker(markerRepository: MarkerRepository): UseCase<LiveData<DataState<Marker>>> =
        GetMarker(markerRepository)
}