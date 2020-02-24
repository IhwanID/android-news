package id.ihwan.gitsnews.core.data.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.ihwan.gitsnews.core.network.response.ArticleListResponse
import id.ihwan.gitsnews.core.network.service.NewsService
import javax.inject.Inject


class ArticlesDataSourceFactory @Inject constructor(private val service: NewsService): DataSource.Factory<Int, ArticleListResponse>() {

    private val dataSourceLiveData = MutableLiveData<ArticlesDataSource>()

    override fun create(): DataSource<Int, ArticleListResponse> {
        val dataSource = ArticlesDataSource(service)
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }

}