package id.ihwan.gitsnews.feature.home.viewmodel

import androidx.lifecycle.MutableLiveData
import id.ihwan.gitsnews.core.network.response.ArticleListResponse
import id.ihwan.gitsnews.core.network.service.NewsService
import id.ihwan.gitsnews.core.platform.BaseViewModel
import id.ihwan.gitsnews.feature.home.model.Articles
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val service: NewsService
) : BaseViewModel() {

    val headline = MutableLiveData<List<Articles>>()
    val everything = MutableLiveData<List<Articles>>()


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

}