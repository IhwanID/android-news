package id.ihwan.gitsnews.feature.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.databinding.ActivityDetailBinding
import id.ihwan.gitsnews.feature.home.model.Articles

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val bundle = intent.extras
        val article = bundle?.getParcelable<Articles>("article")

        binding.model = article

    }


}
