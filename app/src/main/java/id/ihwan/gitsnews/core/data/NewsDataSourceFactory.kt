package id.ihwan.gitsnews.core.data

import androidx.paging.DataSource
import id.ihwan.gitsnews.feature.home.model.News

class NewsDataSourceFactory:  DataSource.Factory<Int, News.Articles>()  {
    override fun create(): DataSource<Int, News.Articles> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}