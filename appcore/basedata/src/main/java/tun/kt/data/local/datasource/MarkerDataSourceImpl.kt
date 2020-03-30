package tun.kt.data.local.datasource

import tun.kt.data.DataState
import tun.kt.data.datasource.MarkerDataSource
import tun.kt.data.local.dao.MarkerDAO
import tun.kt.data.local.model.Marker
import java.lang.Exception
import javax.inject.Inject

class MarkerDataSourceImpl @Inject constructor(private val markerDAO: MarkerDAO) :
    MarkerDataSource {
    override suspend fun getMarkers(): DataState<List<Marker>> =
        try {
            DataState.Success(markerDAO.selectAllMarker())
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun getMarkers(lat: Long, long: Long): DataState<Marker> =
        try {
            DataState.Success(markerDAO.selectMarker(lat.toString(), long.toString()))
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun saveMarkers(marker: Marker): DataState<Boolean> =
        try {
            markerDAO.insertMarker(marker)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }


    override suspend fun deleteMarker(marker: Marker): DataState<Boolean> =
        try {
            markerDAO.delete(marker)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }


    override suspend fun deleteMarkers(markers: List<Marker>): DataState<Boolean> =
        try {
            markerDAO.delete(markers)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }


    override suspend fun updateMarker(marker: Marker): DataState<Boolean> =
        try {
            markerDAO.updateMarker(marker)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun updateMarkers(markers: List<Marker>): DataState<Boolean> =
        try {
            markerDAO.updateMarker(markers)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }
}