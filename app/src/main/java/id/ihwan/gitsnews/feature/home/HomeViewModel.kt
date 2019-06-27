package id.ihwan.gitsnews.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import id.ihwan.gitsnews.BuildConfig
import id.ihwan.gitsnews.core.network.service.NewsService
import id.ihwan.gitsnews.feature.headline.News
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel() {

    fun requestHeadline(){
        NewsService.instance()
            .getTopHeadline("id", BuildConfig.API_KEY)
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