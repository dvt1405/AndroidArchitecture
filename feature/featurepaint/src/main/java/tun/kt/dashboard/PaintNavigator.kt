package tun.kt.dashboard

import android.view.View

interface PaintNavigator {
    fun navigateToDisplayImage(view: View, captureContent: ByteArray?)
    fun navigateToMap(view: View)
}