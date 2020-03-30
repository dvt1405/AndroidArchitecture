package tun.kt.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import me.vponomarenko.injectionmanager.x.XInjectionManager

class PaintFragment() : Fragment() {
    private val navigator: PaintNavigator by lazy {
        XInjectionManager.findComponent<PaintNavigator>()
    }
    private var captureContent: ByteArray? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.undo.setOnClickListener {
            view.paintView.undo()
        }
        view.redo.setOnClickListener {
            view.paintView.redo()
        }
        view.delete.setOnClickListener {
            view.paintView.clear()
        }
        view.capture.setOnClickListener {
            captureContent = view.paintView.getPicture(null)
            navigator.navigateToDisplayImage(it, captureContent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        PaintFragment.navigator = null
    }

    companion object {
        var navigator: PaintNavigator? = null
    }
}