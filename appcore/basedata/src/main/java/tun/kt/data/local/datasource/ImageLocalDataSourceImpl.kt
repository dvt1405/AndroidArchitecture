package tun.kt.data.local.datasource

import tun.kt.data.DataState
import tun.kt.data.datasource.ImageLocalDataSource
import tun.kt.data.local.dao.ImageDAO
import tun.kt.data.local.dao.ImageMarkerDAO
import tun.kt.data.local.model.Image
import tun.kt.data.local.model.ImagesMarker
import tun.kt.data.model.Marker
import java.lang.Exception
import javax.inject.Inject

class ImageLocalDataSourceImpl @Inject constructor(
    private val imageDAO: ImageDAO,
    private val imageMarkerDAO: ImageMarkerDAO
) : ImageLocalDataSource {
    override suspend fun getImages(): DataState<List<Image>> =
        try {
            DataState.Success(imageDAO.getImages())
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun getImages(marker: Marker): DataState<List<ImagesMarker>> =
        try {
            DataState.Success(imageMarkerDAO.getImageOfMarker(marker.id!!))
        } catch (e: Exception) {
            DataState.Failure(e)
        }


    override suspend fun getImage(image: Image): DataState<Image> =
        try {
            DataState.Success(imageDAO.getImage(image.idImage))
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun saveImages(listImages: List<Image>): DataState<Boolean> =
        try {
            imageDAO.insertImage(listImages)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun saveImage(image: Image): DataState<Boolean> =
        try {
            imageDAO.insertImage(image)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }


    override suspend fun deleteImage(image: Image): DataState<Boolean> =
        try {
            imageDAO.deleteImage(image)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun deletedImages(images: List<Image>): DataState<Boolean> =
        try {
            imageDAO.deleteImage(images)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }

}