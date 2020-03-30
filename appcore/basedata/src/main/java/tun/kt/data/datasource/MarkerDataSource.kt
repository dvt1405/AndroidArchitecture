package tun.kt.data.datasource

import tun.kt.data.local.model.Marker
import tun.kt.data.DataState
interface MarkerDataSource {
    suspend fun getMarkers(): DataState<List<Marker>>
    suspend fun getMarkers(lat: Long, long: Long): DataState<Marker>
    suspend fun saveMarkers(marker: Marker): DataState<Boolean>
    suspend fun deleteMarker(marker: Marker): DataState<Boolean>
    suspend fun deleteMarkers(markers: List<Marker>): DataState<Boolean>
    suspend fun updateMarker(marker: Marker): DataState<Boolean>
    suspend fun updateMarkers(markers: List<Marker>): DataState<Boolean>
}