package tun.kt.data.local.datasource

import tun.kt.data.DataState
import tun.kt.data.datasource.PaintDataSource
import tun.kt.data.local.dao.PaintDAO
import tun.kt.data.model.Paint
import java.lang.Exception
import javax.inject.Inject

class PaintDataSourceImpl @Inject constructor(val paintDAO: PaintDAO) : PaintDataSource {
    override suspend fun saveImage(paint: Paint): DataState<Boolean> =
        try {
            paintDAO.insertPaint(paint)
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }

    override suspend fun getImage(): DataState<List<Paint>> =
        try {
            DataState.Success(paintDAO.getPaintCaptures())
        } catch (e: Exception) {
            DataState.Failure(e)
        }
}