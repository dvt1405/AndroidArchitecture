package tun.kt.data.local.dao

import androidx.room.*
import tun.kt.data.local.model.Image
import tun.kt.data.model.Paint

@Dao
interface PaintDAO {
    @Query("SELECT * FROM Paint WHERE id = :id")
    suspend fun getPaintCapture(id: Long): Paint

    @Query("SELECT * FROM Paint")
    suspend fun getPaintCaptures(): List<Paint>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaint(paint: Paint)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaint(paintlList: List<Image>)

    @Update
    suspend fun updatePaint(paint: Paint)

    @Delete
    suspend fun deleteImage(paint: Paint)

    @Delete
    suspend fun deleteImage(paint: List<Paint>)
}