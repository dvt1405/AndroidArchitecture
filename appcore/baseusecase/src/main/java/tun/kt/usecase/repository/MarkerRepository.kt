package tun.kt.usecase.repository

import tun.kt.data.DataState
import tun.kt.data.datasource.MarkerDataSource
import tun.kt.data.local.model.Marker
import java.lang.Exception
import javax.inject.Inject

interface MarkerRepository {
    suspend fun insertMarker(marker: Marker): DataState<Boolean>
    suspend fun getMarkers(): DataState<List<Marker>>
}

class MarkerRepositoryImpl @Inject constructor(private val markerDataSource: MarkerDataSource) :
    MarkerRepository {
    override suspend fun insertMarker(marker: Marker): DataState<Boolean> =
        try {
            markerDataSource.saveMarkers(marker)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }


    override suspend fun getMarkers(): DataState<List<Marker>> =
        try {
            markerDataSource.getMarkers()
        } catch (e: Exception) {
            DataState.Failure(e)
        }

}