package id.ihwan.gitsnews.core.data.remote

import androidx.paging.PageKeyedDataSource
import id.ihwan.gitsnews.core.network.response.ArticleListResponse
import id.ihwan.gitsnews.core.network.service.NewsService
import id.ihwan.gitsnews.feature.home.model.Articles
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArticlesDataSource @Inject constructor(
    private val service: NewsService
): PageKeyedDataSource<Int, Articles>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Articles>
    ) {
        service
            .getEverything("jokowi")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ArticleListResponse> {
                override fun onSuccess(response: ArticleListResponse) {
                    callback.onResult(response.articles, null, 2)
                }

                override fun onSubscribe(d: Disposable) {
                    //do nothing
                }

                override fun onError(e: Throwable) {
                    //do nothing
                }

            }
            )
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Articles>
    ) {
        service
            .getEverything("jokowi", page = params.key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ArticleListResponse> {
                override fun onSuccess(response: ArticleListResponse) {

                    callback.onResult(response.articles, params.key+1)
                }

                override fun onSubscribe(d: Disposable) {
                    //do nothing
                }

                override fun onError(e: Throwable) {
                    //do nothing
                }

            }
            )
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Articles>
    ) {
        //do nothing
    }
}