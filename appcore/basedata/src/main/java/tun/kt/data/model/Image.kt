package tun.kt.data.model

import com.google.gson.annotations.SerializedName
import tun.kt.data.Mapper

data class Image(
    @SerializedName("id")
    var id: String?,
    @SerializedName("owner")
    var owner: String?,
    @SerializedName("secret")
    var secret: String?,
    @SerializedName("farm")
    var farm: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("isPublic")
    var isPublic: String?,
    @SerializedName("isFriend")
    var isFriend: String?,
    @SerializedName("isFamily")
    var isFamily: String?,
    @SerializedName("server")
    var server: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("url")
    var url: String?,
    var byteArray: ByteArray?
) : Mapper<tun.kt.data.local.model.Image, Image> {

    override fun mapFrom(input: tun.kt.data.local.model.Image): Image {
        return Image(
            input.idImage,
            input.ownerImg,
            input.secret,
            input.farm,
            input.title,
            input.isPublic,
            input.isFriend,
            input.isFamily,
            input.server,
            null,
            input.url,
            input.content
        )
    }

    override fun mapTo(input: Image): tun.kt.data.local.model.Image {
        return tun.kt.data.local.model.Image(
            input.id ?: error(0),
            input.title,
            input.byteArray,
            input.url,
            input.server,
            input.farm,
            input.isPublic,
            input.isFriend,
            input.isFamily,
            input.server,
            input.owner
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        if (id != other.id) return false
        if (owner != other.owner) return false
        if (secret != other.secret) return false
        if (farm != other.farm) return false
        if (title != other.title) return false
        if (isPublic != other.isPublic) return false
        if (isFriend != other.isFriend) return false
        if (isFamily != other.isFamily) return false
        if (server != other.server) return false
        if (content != other.content) return false
        if (url != other.url) return false
        if (byteArray != null) {
            if (other.byteArray == null) return false
            if (!byteArray!!.contentEquals(other.byteArray!!)) return false
        } else if (other.byteArray != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (owner?.hashCode() ?: 0)
        result = 31 * result + (secret?.hashCode() ?: 0)
        result = 31 * result + (farm?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (isPublic?.hashCode() ?: 0)
        result = 31 * result + (isFriend?.hashCode() ?: 0)
        result = 31 * result + (isFamily?.hashCode() ?: 0)
        result = 31 * result + (server?.hashCode() ?: 0)
        result = 31 * result + (content?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (byteArray?.contentHashCode() ?: 0)
        return result
    }

}