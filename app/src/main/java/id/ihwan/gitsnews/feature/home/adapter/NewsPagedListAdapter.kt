package id.ihwan.gitsnews.feature.home.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.gitsnews.databinding.ListItemNewsBinding
import id.ihwan.gitsnews.feature.home.model.News

class NewsPagedListAdapter(val onClick: (News.Articles) -> Unit): PagedListAdapter<News.Articles, NewsPagedListAdapter.NewsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<News.Articles>(){
            override fun areContentsTheSame(oldItem: News.Articles, newItem: News.Articles): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areItemsTheSame(oldItem: News.Articles, newItem: News.Articles): Boolean {
                return oldItem == newItem
            }
        }
    }
    class NewsViewHolder(private val binding: ListItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: News.Articles) {
            binding.apply {
                model= items
                executePendingBindings()
            }
        }

    }
}