package tun.kt.usecase.di

import dagger.Module
import dagger.Provides
import tun.kt.data.datasource.ImageLocalDataSource
import tun.kt.data.datasource.ImageNetworkDataSource
import tun.kt.data.datasource.MarkerDataSource
import tun.kt.usecase.repository.ImageRepository
import tun.kt.usecase.repository.ImageRepositoryImpl
import tun.kt.usecase.repository.MarkerRepository
import tun.kt.usecase.repository.MarkerRepositoryImpl

@Module
class RepositoryModule() {
    @Provides
    @UseCaseScope
    fun providesImageRepository(
        imageLocalDataSource: ImageLocalDataSource,
        imageNetworkDataSource: ImageNetworkDataSource
    ): ImageRepository = ImageRepositoryImpl(imageNetworkDataSource, imageLocalDataSource)

    @Provides
    @UseCaseScope
    fun providesMarkerRepository(markerDataSource: MarkerDataSource): MarkerRepository =
        MarkerRepositoryImpl(markerDataSource)
}