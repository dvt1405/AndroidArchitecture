package tun.kt.baseprojectroxwin.fragment

import tun.kt.data.model.Image
import tun.kt.service.service.AuthFirebaseService
import tun.kt.usecase.usecase.GetImage
import tun.kt.usecase.usecase.UseCase
import javax.inject.Inject

data class HomeFragmentInteractor @Inject constructor(var getImage: GetImage, var authFirebaseService: AuthFirebaseService) {
}