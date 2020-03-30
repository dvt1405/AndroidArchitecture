package tun.kt.data.local.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ImagesMarker(
    @Embedded
    var markerRelation: Marker,
    @Relation(
        parentColumn = "idMarker",
        entityColumn = "idImage",
        associateBy  = Junction(ImagesMarkerRelation::class)
    )
    var images: List<Image>?
)  {
}