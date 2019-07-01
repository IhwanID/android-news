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
import id.ihwan.gitsnews.databinding.FragmentDesignBinding
import id.ihwan.gitsnews.core.utils.LoadingDialog


class DesignFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): DesignFragment {
            return DesignFragment()
        }
    }
    private lateinit var binding: FragmentDesignBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_design, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@DesignFragment.adapter
            setHasFixedSize(true)
        }

        viewModel.requestDesign()

        viewModel.getLoading().observe(this, Observer {
            if (it) LoadingDialog.show(activity) else LoadingDialog.dismiss()
        })

        viewModel.design.observe(this, Observer {
            adapter.loadData(it)
        })


    }


}