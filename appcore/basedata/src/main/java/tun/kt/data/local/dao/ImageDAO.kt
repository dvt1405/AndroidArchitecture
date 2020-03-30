package tun.kt.data.local.dao

import androidx.room.*
import tun.kt.data.local.model.Image

@Dao
interface ImageDAO {
    @Query("SELECT * FROM IMAGE WHERE idImage = :id")
    suspend fun getImage(id: String): Image

    @Query("SELECT * FROM IMAGE")
    suspend fun getImages(): List<Image>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(imageModel: Image)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(imageModelList: List<Image>)

    @Update
    suspend fun updateImage(imageModel: Image)

    @Delete
    suspend fun deleteImage(imageModel: Image)

    @Delete
    suspend fun deleteImage(imageModels: List<Image>)
}