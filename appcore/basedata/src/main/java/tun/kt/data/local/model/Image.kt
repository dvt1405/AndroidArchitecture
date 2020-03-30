package tun.kt.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "image"
)
data class Image(
    @PrimaryKey()
    var idImage: String,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "content")
    var content: ByteArray?,
    @ColumnInfo(name = "url")
    var url: String? = "",
    @ColumnInfo(name = "secret")
    var secret: String?,
    @ColumnInfo(name = "farm")
    var farm: String?,
    @ColumnInfo(name = "isPublic")
    var isPublic: String?,
    @ColumnInfo(name = "isFriend")
    var isFriend: String?,
    @ColumnInfo(name = "isFamily")
    var isFamily: String?,
    @ColumnInfo(name = "server")
    var server: String?,
    @ColumnInfo(name = "owner")
    var ownerImg: String?
) : RoomDBModel {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        if (idImage != other.idImage) return false
        if (title != other.title) return false
        if (content != null) {
            if (other.content == null) return false
            if (!content!!.contentEquals(other.content!!)) return false
        } else if (other.content != null) return false
        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = idImage.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (content?.contentHashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        return result
    }
}