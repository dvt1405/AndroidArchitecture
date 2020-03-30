package tun.kt.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import tun.kt.data.local.dao.ImageDAO
import tun.kt.data.local.dao.ImageMarkerDAO
import tun.kt.data.local.dao.MarkerDAO
import tun.kt.data.local.dao.PaintDAO
import tun.kt.data.local.model.Image
import tun.kt.data.local.model.ImagesMarkerRelation
import tun.kt.data.local.model.Marker
import tun.kt.data.model.Paint

@Database(
    entities = [Marker::class, Image::class, ImagesMarkerRelation::class, Paint::class],
    version = 1,
    exportSchema = false
)
abstract class DB : RoomDatabase() {
    abstract fun imageDAO(): ImageDAO
    abstract fun markerDAO(): MarkerDAO
    abstract fun imageMarkerDAO(): ImageMarkerDAO
    abstract fun paintDAO(): PaintDAO

    companion object {
        private const val DB_NAME = "map.db"
        private var INSTANCE: DB? = null

        fun getDatabase(
            context: Context
        ): DB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}