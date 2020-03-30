package tun.kt.data.local.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "image_marker", primaryKeys = ["idMarker", "idImage"])
data class ImagesMarkerRelation(
    var idMarker: String,
    var idImage: String
): RoomDBModel {
}