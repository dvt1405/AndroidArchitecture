package tun.kt.data.datasource

import tun.kt.data.DataState
import tun.kt.data.model.Paint

interface PaintDataSource {
    suspend fun saveImage(paint: Paint): DataState<Boolean>
    suspend fun getImage(): DataState<List<Paint>>
}