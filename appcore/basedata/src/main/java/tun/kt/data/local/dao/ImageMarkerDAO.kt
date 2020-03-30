package tun.kt.data.local.dao

import androidx.room.*
import tun.kt.data.local.model.ImagesMarker
import tun.kt.data.local.model.ImagesMarkerRelation

@Dao
interface ImageMarkerDAO {
    @Transaction
    @Query("SELECT * FROM image_marker WHERE idMarker = :id")
    suspend fun getImageOfMarker(id: String): List<ImagesMarker>

    @Update
    suspend fun updateImageMarker(imageMarkerModel: ImagesMarkerRelation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageOfMarker(imageMarkerModel: ImagesMarkerRelation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageOfMarker(imageMarkerModels: List<ImagesMarkerRelation>)

    @Delete
    suspend fun deleteImageOfMarker(imageMarker: ImagesMarkerRelation)

    @Delete
    suspend  fun deleteImageOfMarker(imageMarkerModel: List<ImagesMarkerRelation>)

    @Update
    suspend fun update(imageMarkerModel: ImagesMarkerRelation)

    @Query("DELETE FROM IMAGE_MARKER WHERE idimage = :idImage")
    suspend fun deleteImageOfMarker(idImage: String)
}