package tun.kt.data.network.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tun.kt.data.DataState
import tun.kt.data.Constant
import tun.kt.data.datasource.ImageNetworkDataSource
import tun.kt.data.local.dao.ImageDAO
//import tun.kt.data.di.DataComponent
import tun.kt.data.model.Image
import tun.kt.data.model.Marker
import tun.kt.data.model.ListImageResponse
import tun.kt.data.network.API
import java.lang.Exception
import javax.inject.Inject

class ImageNetworkDataSourceImpl @Inject constructor(private val api: API, val imageDAO: ImageDAO) :
    ImageNetworkDataSource {
    val liveData = MutableLiveData<DataState<List<Image>>>()

    override fun getImages(
        page: String,
        text: String,
        marker: Marker
    ): LiveData<DataState<List<Image>>> {
        api.searchImage(
            Constant.SEARCH_METHOD,
            Constant.KEY_API_FLICKR,
            Constant.JSON_FORMAT,
            Constant.NO_JSON_CALL_BACK,
            page,
            marker.latitude,
            marker.lontitude,
            "10"
        ).enqueue(object : Callback<ListImageResponse> {
            override fun onFailure(call: Call<ListImageResponse>, t: Throwable) {
                liveData.postValue(DataState.Failure(t))
            }

            override fun onResponse(
                call: Call<ListImageResponse>,
                response: Response<ListImageResponse>
            ) {
                if (response.isSuccessful) {
                    when (response.code()) {
                        in 200..299 -> {
                            try {
                                runBlocking {
                                    imageDAO.insertImage(response.body()!!.photos!!.photo!!.map { image ->
                                        tun.kt.data.local.model.Image(
                                            image.id!!,
                                            image.title,
                                            image.byteArray,
                                            image.url,
                                            image.secret,
                                            image.farm,
                                            image.isPublic,
                                            image.isFriend,
                                            image.isFamily,
                                            image.server,
                                            image.owner
                                        )
                                    })
                                }
                                val data =
                                    response.body()!!.photos!!.photo!!.map { image ->
                                        image.url = "https://farm${image.farm}.staticflickr.com/${image.server}/${image.id}_${image.secret}.jpg"
                                        return@map image
                                    }
                                liveData.postValue(DataState.Success(data))
                            } catch (e: Exception) {
                                liveData.postValue(DataState.Failure(e))
                            }
                        }
                        else -> {
                            liveData.postValue(DataState.Failure(Throwable("Error while fetch data!")))
                        }
                    }
                } else {
                    liveData.postValue(DataState.Failure(Throwable("Network not successfully!")))
                }
            }
        })
        return liveData
    }

    override fun getImages(marker: Marker): DataState<ListImageResponse> {
        TODO("Not yet implemented")
    }

    override fun downloadImages(): DataState<ByteArray> {
        TODO("Not yet implemented")
    }

}