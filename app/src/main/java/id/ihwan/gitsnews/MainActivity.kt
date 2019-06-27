package id.ihwan.gitsnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import id.ihwan.gitsnews.feature.home.HomeViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.requestHeadline()
        viewModel.requestEverything()
    }
}
