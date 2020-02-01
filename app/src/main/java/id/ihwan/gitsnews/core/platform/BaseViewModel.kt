package id.ihwan.gitsnews.core.platform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    private val loading = MutableLiveData<Boolean>()


    protected fun startLoading() = loading.postValue(true)


    protected fun finishLoading() = loading.postValue(false)

    fun getLoading(): LiveData<Boolean> = loading

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) compositeDisposable.clear()
    }
}
