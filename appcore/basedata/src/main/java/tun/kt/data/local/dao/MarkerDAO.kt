package tun.kt.data.local.dao

import androidx.room.*
import tun.kt.data.local.model.Marker

@Dao
interface MarkerDAO {
    @Query("SELECT * FROM MARKER WHERE marker.idMarker = :id")
    suspend fun selectMarker(id: Int): Marker

    @Query("SELECT * FROM MARKER WHERE latitude = :lat AND longitude= :lon")
    suspend fun selectMarker(lat: String, lon: String): Marker

    @Query("SELECT * FROM MARKER")
    suspend fun selectAllMarker(): List<Marker>

    @Insert
    suspend fun insertListMarker(markers: List<Marker>)

    @Insert
    suspend fun insertMarker(Marker: Marker)

    @Update
    suspend fun updateMarker(Marker: Marker)

    @Update
    suspend fun updateMarker(Markers: List<Marker>)

    @Delete
    suspend fun delete(Marker: Marker)

    @Delete
    suspend fun delete(Marker: List<Marker>)

    @Query("DELETE FROM MARKER WHERE idMarker = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM MARKER WHERE marker.latitude = :lat AND marker.longitude = :lon")
    suspend fun delete(lat: String, lon: String)
}