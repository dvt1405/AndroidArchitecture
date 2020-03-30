package tun.kt.usecase.repository

import android.util.Log
import androidx.lifecycle.LiveData
import tun.kt.data.DataState
import tun.kt.data.datasource.ImageLocalDataSource
import tun.kt.data.datasource.ImageNetworkDataSource
import tun.kt.data.model.Image
import tun.kt.data.model.Marker
import javax.inject.Inject

interface ImageRepository {
    fun getImages(marker: Marker): LiveData<DataState<List<Image>>>
}

class ImageRepositoryImpl @Inject constructor(
    private val imageNetworkDataSource: ImageNetworkDataSource,
    val imageLocalDataSource: ImageLocalDataSource
) : ImageRepository {
    override fun getImages(marker: Marker): LiveData<DataState<List<Image>>> {
        return imageNetworkDataSource.getImages("1", "", marker)
    }

}