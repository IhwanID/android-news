package id.ihwan.gitsnews.core.platform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected val loading = MutableLiveData<Boolean>()


    protected fun onRequestStart(){
        loading.value = true
    }

    protected fun onRequestFinish(){
        loading.value = false
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
