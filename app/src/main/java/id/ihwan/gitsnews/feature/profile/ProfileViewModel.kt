package id.ihwan.gitsnews.feature.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.ihwan.gitsnews.core.network.service.NewsService
import id.ihwan.gitsnews.core.platform.BaseViewModel
import javax.inject.Inject

class ProfileViewModel  @Inject constructor(
    private val service: NewsService
) : BaseViewModel() {

    private val profile = MutableLiveData<Profile>()

    init { profile.postValue(Profile()) }

    fun getProfile(): LiveData<Profile> = profile
}