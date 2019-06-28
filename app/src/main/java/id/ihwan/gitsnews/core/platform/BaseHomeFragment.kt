package id.ihwan.gitsnews.core.platform

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import id.ihwan.gitsnews.feature.home.adapter.NewsAdapter
import id.ihwan.gitsnews.feature.home.view.HomeActivity
import id.ihwan.gitsnews.feature.home.viewmodel.HomeViewModel

open class BaseHomeFragment : Fragment(){

    lateinit var activity: HomeActivity

    val adapter: NewsAdapter by lazy {
        NewsAdapter()
    }

    val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = getActivity() as HomeActivity
    }
}