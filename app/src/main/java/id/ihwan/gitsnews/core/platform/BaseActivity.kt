package id.ihwan.gitsnews.core.platform

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import id.ihwan.gitsnews.core.utils.hideKeyboard
import id.ihwan.gitsnews.core.utils.hideWait
import id.ihwan.gitsnews.core.utils.showWait

abstract class BaseActivity<B : ViewDataBinding> constructor(
    @LayoutRes val layoutRes: Int,
    private val isFullScreen: Boolean = false
): DaggerAppCompatActivity() {

    protected lateinit var binding: B

    protected open fun bindView() {
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }
    protected val loadingObserver by lazy {
        Observer<Boolean> { isLoading -> if (isLoading) showWait() else hideWait() }
    }

    fun setFullScreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val decorView = window.decorView
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (isFullScreen) setFullScreen()
        bindView()
    }
    override fun onStop() {
        super.onStop()
        hideWait()
        hideKeyboard()
    }

}