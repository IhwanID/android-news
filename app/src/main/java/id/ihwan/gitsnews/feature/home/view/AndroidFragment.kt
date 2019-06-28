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
import id.ihwan.gitsnews.databinding.FragmentAndroidBinding

class AndroidFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): AndroidFragment {
            return AndroidFragment()
        }
    }

    private lateinit var binding: FragmentAndroidBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_android, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@AndroidFragment.adapter
            setHasFixedSize(true)
        }

        viewModel.requestAndroid()

        viewModel.android.observe(this, Observer {
            adapter.loadData(it)
        })
    }

}
