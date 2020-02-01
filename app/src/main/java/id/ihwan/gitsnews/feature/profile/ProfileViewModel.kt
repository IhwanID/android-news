package id.ihwan.gitsnews.feature.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.ihwan.gitsnews.core.platform.BaseViewModel

class ProfileViewModel: BaseViewModel() {

    private val profile = MutableLiveData<Profile>()

    init { profile.postValue(Profile()) }

    fun getProfile(): LiveData<Profile> = profile
}