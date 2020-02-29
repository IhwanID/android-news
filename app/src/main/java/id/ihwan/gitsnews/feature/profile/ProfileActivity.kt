package id.ihwan.gitsnews.feature.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.platform.BaseActivity
import id.ihwan.gitsnews.databinding.ActivityProfileBinding
import id.ihwan.gitsnews.feature.home.view.WebViewActivity
import javax.inject.Inject

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: ProfileViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getProfile().observe(this, Observer {
           binding.profile = it
        })
    }

    fun goToDetail(url: String?, title: String?) {

        val i = Intent(this, WebViewActivity::class.java).apply {
            putExtra("url", url)
            putExtra("title", title)
        }
        startActivity(i)
    }
}
