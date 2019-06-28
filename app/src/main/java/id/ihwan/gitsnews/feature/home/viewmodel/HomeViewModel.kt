package id.ihwan.gitsnews.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.ihwan.gitsnews.BuildConfig
import id.ihwan.gitsnews.core.network.service.NewsService
import id.ihwan.gitsnews.core.platform.BaseViewModel
import id.ihwan.gitsnews.feature.home.model.News
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel: BaseViewModel() {

    val articles = MutableLiveData<List<News.Articles>>()

    fun requestHeadline(){
        NewsService.instance()
            .getTopHeadline("id", BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<News>{
                override fun onSuccess(data: News) {
                    data.let {
                        articles.postValue(data.articles)
                    }
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("Subskreb", d.toString())
                }

                override fun onError(e: Throwable) {
                    Log.d("Erorr", e.toString())
                }

            }
            )
    }


    fun requestEverything(){
        NewsService.instance()
            .getEverything("android", BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<News>{
                override fun onSuccess(t: News) {
                    Log.d("Sukses", t.toString())
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("Subskreb", d.toString())
                }

                override fun onError(e: Throwable) {
                    Log.d("Erorr", e.toString())
                }

            }
            )
    }
}