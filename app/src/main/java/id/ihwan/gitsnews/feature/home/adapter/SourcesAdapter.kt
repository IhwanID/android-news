package id.ihwan.gitsnews.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.gitsnews.core.platform.BaseAdapter
import id.ihwan.gitsnews.databinding.ListItemSourcesBinding
import id.ihwan.gitsnews.feature.home.model.Sources

class SourcesAdapter(val onClick: (Sources) -> Unit) :
    BaseAdapter<SourcesAdapter.ViewHolder, Sources>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemSourcesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sources = models[position]
        holder.apply {
            bind(sources)
            itemView.setOnClickListener { onClick(sources) }
        }
    }


    class ViewHolder(private val binding: ListItemSourcesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Sources) {
            binding.apply {
                model = item
                executePendingBindings()
            }
        }
    }
}