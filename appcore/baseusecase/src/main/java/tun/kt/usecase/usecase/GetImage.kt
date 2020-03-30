package tun.kt.usecase.usecase

import androidx.lifecycle.LiveData
import tun.kt.data.DataState
import tun.kt.data.model.Image
import tun.kt.data.model.Marker
import tun.kt.usecase.repository.ImageRepository
import javax.inject.Inject


class GetImage @Inject constructor(private val imageRepository: ImageRepository) :
    UseCase<DataState<Image>> {
    override fun execute(): LiveData<DataState<Image>> {
        TODO("Not yet implemented")
    }

    operator fun invoke(marker: Marker) = imageRepository.getImages(marker)
}