package tun.kt.usecase.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tun.kt.data.DataState
import tun.kt.data.model.Marker
import tun.kt.usecase.repository.MarkerRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class GetMarker @Inject constructor(val markerRepository: MarkerRepository) : UseCase<LiveData<DataState<Marker>>> {
    private val liveData = MutableLiveData<DataState<Marker>>()
    override fun execute(): LiveData<LiveData<DataState<Marker>>> {
        return liveData as LiveData<LiveData<DataState<Marker>>>
    }
}