package tun.kt.data.datasource
import tun.kt.data.DataState
import tun.kt.data.model.Marker
import tun.kt.data.local.model.Image
import tun.kt.data.local.model.ImagesMarker

interface ImageLocalDataSource {
    suspend fun getImages(): DataState<List<Image>>
    suspend fun getImages(marker: Marker): DataState<List<ImagesMarker>>
    suspend fun getImage(image: Image): DataState<Image>
    suspend fun saveImages(listImages: List<Image>): DataState<Boolean>
    suspend fun saveImage(image: Image): DataState<Boolean>
    suspend fun deleteImage(image: Image): DataState<Boolean>
    suspend fun deletedImages(images: List<Image>): DataState<Boolean>
}