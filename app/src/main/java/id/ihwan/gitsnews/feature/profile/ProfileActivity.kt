package id.ihwan.gitsnews.feature.profile

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.platform.BaseActivity
import id.ihwan.gitsnews.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    val viewModel: ProfileViewModel by lazy {
        ViewModelProviders.of(this).get(ProfileViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProfile().observe(this, Observer {
            Log.d("data", it.toString())
        })
    }
}
