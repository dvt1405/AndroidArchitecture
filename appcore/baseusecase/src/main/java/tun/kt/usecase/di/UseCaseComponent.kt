package tun.kt.usecase.di

import android.content.Context
import dagger.Component
import tun.kt.data.DataState
import tun.kt.data.di.DataComponent
import tun.kt.data.model.Image
import tun.kt.usecase.repository.ImageRepository
import tun.kt.usecase.repository.MarkerRepository
import tun.kt.usecase.usecase.GetImage
import tun.kt.usecase.usecase.GetMarker
import tun.kt.usecase.usecase.UseCase

@UseCaseScope
@Component(modules = [RepositoryModule::class, UseCaseModule::class], dependencies = [DataComponent::class])
interface UseCaseComponent {
    val getImage:  GetImage
    val imageRepository: ImageRepository
    val markerRepository: MarkerRepository
    val getMarker: GetMarker
    @Component.Builder
    interface Builder {
        fun build(): UseCaseComponent
        fun dataComponent(dataComponent: DataComponent): Builder
    }
}