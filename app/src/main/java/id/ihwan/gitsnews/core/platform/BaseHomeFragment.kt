package id.ihwan.gitsnews.core.platform

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import id.ihwan.gitsnews.feature.home.adapter.NewsAdapter
import id.ihwan.gitsnews.feature.home.model.News
import id.ihwan.gitsnews.feature.home.view.HomeActivity
import id.ihwan.gitsnews.feature.home.viewmodel.HomeViewModel
import id.ihwan.gitsnews.feature.home.view.DetailActivity

open class BaseHomeFragment : Fragment(){

    lateinit var activity: HomeActivity

    val adapter: NewsAdapter by lazy {
        NewsAdapter{article ->
            goToDetail(article)

        }
    }

    private fun goToDetail(article: News.Articles) {

        val i = Intent(activity, DetailActivity::class.java)
        i.putExtra("article", article)
        startActivity(i)
    }

    val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = getActivity() as HomeActivity
    }
}