package tun.kt.data.local.dao

interface RoomDAO {
    var columnName: String
    suspend fun getRoomModel(id: String)
}