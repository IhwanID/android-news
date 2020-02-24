package id.ihwan.gitsnews.feature.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ihwan.gitsnews.core.data.remote.ArticlesDataSourceFactory
import id.ihwan.gitsnews.core.network.response.ArticleListResponse
import id.ihwan.gitsnews.core.network.response.SourceListResponse
import id.ihwan.gitsnews.core.network.service.NewsService
import id.ihwan.gitsnews.core.platform.BaseViewModel
import id.ihwan.gitsnews.feature.home.model.Articles
import id.ihwan.gitsnews.feature.home.model.Sources
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val service: NewsService
) : BaseViewModel() {


        val sourceFactory = ArticlesDataSourceFactory(service)
        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()


    val headline = MutableLiveData<List<Articles>>()
    val everything = MutableLiveData<List<Articles>>()
    val sources = MutableLiveData<List<Sources>>()






    fun getEverything(): LiveData<PagedList<Articles>>{
        return  LivePagedListBuilder(sourceFactory, config).build()
    }

    fun requestHeadline() {
        service
            .getTopHeadline("id")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { startLoading() }
            .doAfterTerminate { finishLoading() }
            .subscribe(object : SingleObserver<ArticleListResponse> {
                override fun onSuccess(t: ArticleListResponse) {
                    headline.postValue(t.articles)
                }

                override fun onSubscribe(d: Disposable) {
                    //do notjing
                }

                override fun onError(e: Throwable) {
                    //do nothing
                }

            })
    }


    fun requestEverything() {
        service
            .getEverything("jokowi")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { startLoading() }
            .doAfterTerminate { finishLoading() }
            .subscribe(object : SingleObserver<ArticleListResponse> {
                override fun onSuccess(t: ArticleListResponse) {
                    everything.postValue(t.articles)
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

    fun requestSources() {
        service
            .getSources()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { startLoading() }
            .doAfterTerminate { finishLoading() }
            .subscribe(object : SingleObserver<SourceListResponse> {
                override fun onSuccess(t: SourceListResponse) {
                    sources.postValue(t.sources)
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

}