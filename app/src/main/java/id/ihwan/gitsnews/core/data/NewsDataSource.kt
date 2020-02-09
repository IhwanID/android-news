package id.ihwan.gitsnews.core.data

import androidx.paging.PageKeyedDataSource
import id.ihwan.gitsnews.feature.home.model.News


class NewsDataSource: PageKeyedDataSource<Int, News.Articles>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, News.Articles>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, News.Articles>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, News.Articles>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}