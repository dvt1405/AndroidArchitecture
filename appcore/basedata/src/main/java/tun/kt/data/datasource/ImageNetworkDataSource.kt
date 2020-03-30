package tun.kt.data.datasource

import androidx.lifecycle.LiveData
import tun.kt.data.DataState
import tun.kt.data.model.Image
import tun.kt.data.model.ListImageResponse
import tun.kt.data.model.Marker

interface ImageNetworkDataSource {
    fun getImages(page: String, text: String, marker: Marker): LiveData<DataState<List<Image>>>
    fun getImages(marker: Marker): DataState<ListImageResponse>
    fun downloadImages(): DataState<ByteArray>
}
