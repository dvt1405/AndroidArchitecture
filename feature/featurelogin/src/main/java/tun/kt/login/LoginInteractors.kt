package tun.kt.login

import tun.kt.data.model.Image
import tun.kt.data.model.Marker
import tun.kt.service.service.AuthFirebaseService
import tun.kt.usecase.usecase.GetImage
import tun.kt.usecase.usecase.GetMarker
import tun.kt.usecase.usecase.UseCase
import javax.inject.Inject

data class LoginInteractors @Inject constructor(
    var getImage: GetImage,
    var getMarker: GetMarker,
    var firebaseService: AuthFirebaseService
) {
}