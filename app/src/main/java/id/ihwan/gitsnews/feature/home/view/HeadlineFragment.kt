package id.ihwan.gitsnews.feature.home.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.platform.BaseHomeFragment
import id.ihwan.gitsnews.databinding.FragmentHeadlineBinding


class HeadlineFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): HeadlineFragment {
            return HeadlineFragment()
        }
    }

    private lateinit var binding: FragmentHeadlineBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_headline, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HeadlineFragment.adapter
            setHasFixedSize(true)
        }

        viewModel.requestHeadline()

        viewModel.articles.observe(this, Observer {
            adapter.loadData(it)
        })
    }


}
