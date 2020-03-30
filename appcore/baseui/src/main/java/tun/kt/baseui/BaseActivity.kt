package tun.kt.baseui

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity() : AppCompatActivity() {
    @LayoutRes
    private var layoutRes: Int = 0

    constructor(@LayoutRes layoutRes: Int) : this() {
        this.layoutRes = layoutRes
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initView()
        initAction()
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    abstract fun initView()
    abstract fun initAction()
}