package tun.kt.subfeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes private val layoutRes: Int) : Fragment() {
    private var attachToRoot: Boolean = false

    constructor(
        @LayoutRes layoutRes: Int,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) : this(layoutRes) {
        this.attachToRoot = attachToRoot
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, attachToRoot)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initAction()
    }

    abstract fun initView(view: View)
    abstract fun initAction()
}