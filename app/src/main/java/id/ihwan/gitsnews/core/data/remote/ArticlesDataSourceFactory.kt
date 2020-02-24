package id.ihwan.gitsnews.core.data.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.ihwan.gitsnews.core.network.service.NewsService
import id.ihwan.gitsnews.feature.home.model.Articles
import javax.inject.Inject


class ArticlesDataSourceFactory @Inject constructor(private val service: NewsService): DataSource.Factory<Int, Articles>() {

    private val dataSourceLiveData = MutableLiveData<ArticlesDataSource>()

    override fun create(): DataSource<Int, Articles> {
        val dataSource = ArticlesDataSource(service)
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }

}