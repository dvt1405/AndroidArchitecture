package tun.kt.data.local.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "marker")
class Marker() : RoomDBModel {
    @PrimaryKey
    @NonNull
    var idMarker: String? = UUID.randomUUID().toString()

    @ColumnInfo(name = "latitude")
    var lat: String? = ""

    @ColumnInfo(name = "longitude")
    var lon: String? = ""

    @ColumnInfo(name = "member")
    var isOldMarker: Boolean? = false

    @ColumnInfo(name = "title")
    var title: String? = ""

    @ColumnInfo(name = "city")
    var city: String? = ""

    @ColumnInfo(name = "country")
    var country: String? = ""
}