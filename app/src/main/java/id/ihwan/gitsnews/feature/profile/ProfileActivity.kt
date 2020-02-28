package id.ihwan.gitsnews.feature.profile

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.platform.BaseActivity
import id.ihwan.gitsnews.databinding.ActivityProfileBinding
import javax.inject.Inject

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: ProfileViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getProfile().observe(this, Observer {
            Log.d("data", it.toString())
        })
    }
}
