package id.ihwan.gitsnews.core.platform

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import id.ihwan.gitsnews.feature.home.adapter.NewsAdapter
import id.ihwan.gitsnews.feature.home.view.HomeActivity
import id.ihwan.gitsnews.feature.home.viewmodel.HomeViewModel
import id.ihwan.gitsnews.feature.home.view.WebViewActivity
import javax.inject.Inject

open class BaseHomeFragment : DaggerFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: HomeViewModel by viewModels { viewModelFactory }

    lateinit var activity: HomeActivity

    val adapter: NewsAdapter by lazy {
        NewsAdapter{article ->
            goToDetail(article.url, article.title)

        }
    }


    fun goToDetail(url: String?, title: String?) {

        val i = Intent(activity, WebViewActivity::class.java).apply {
            putExtra("url", url)
            putExtra("title", title)
        }
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = getActivity() as HomeActivity

    }
}