package tun.kt.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Paint")
data class Paint(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "content")
    var byteArray: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Paint

        if (id != other.id) return false
        if (!byteArray.contentEquals(other.byteArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + byteArray.contentHashCode()
        return result
    }
}