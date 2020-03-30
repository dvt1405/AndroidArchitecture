package tun.kt.dashboard

import tun.kt.usecase.usecase.GetImage
import javax.inject.Inject

data class PaintUseCase @Inject constructor(var getImage: GetImage) {
}