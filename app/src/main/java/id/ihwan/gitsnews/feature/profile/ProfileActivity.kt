package id.ihwan.gitsnews.feature.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ihwan.gitsnews.R

class ProfileActivity : AppCompatActivity() {

    val viewModel: ProfileViewModel by lazy {
        ViewModelProviders.of(this).get(ProfileViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        viewModel.getProfile().observe(this, Observer {
            Log.d("data", it.toString())
        })
    }
}
