package tun.kt.data.model

import com.google.gson.annotations.SerializedName

data class ListImageResponse(
    @SerializedName("photos")
    var photos: Data?
) {
    data class Data(
        @SerializedName("page")
        var page: String?,
        @SerializedName("pages")
        var pages: String?,
        @SerializedName("perpage")
        var perpage: String?,
        @SerializedName("total")
        var total: String?,
        @SerializedName("photo")
        var photo: List<Image>? = null
    )
}