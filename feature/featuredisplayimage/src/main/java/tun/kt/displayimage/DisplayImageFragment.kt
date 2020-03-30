package tun.kt.displayimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import kotlinx.android.synthetic.main.fragment_display_image.*
import kotlinx.android.synthetic.main.fragment_display_image.view.*
import kotlinx.android.synthetic.main.fragment_display_image.view.imageView
import me.vponomarenko.injectionmanager.x.XInjectionManager
import tun.kt.baseui.BaseFragment

class DisplayImageFragment() : BaseFragment(R.layout.fragment_display_image) {
    private var image: String? = null
    override fun initView(view: View) {
        image = arguments?.getString("image")
        view.imageView.setImageBitmap(
            BitmapFactory.decodeByteArray(
                image?.toByteArray(),
                imageView.width,
                imageView.height
            )
        )
    }

    override fun initAction(view: View) {

    }
}