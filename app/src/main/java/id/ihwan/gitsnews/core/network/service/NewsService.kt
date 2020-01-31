package id.ihwan.gitsnews.core.network.service

import id.ihwan.gitsnews.feature.home.model.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    companion object {
        var instance: NewsService? = null

        fun instance() : NewsService{
            instance?.let {
                return it
            }?: return createInstance()
        }

        private fun createInstance(): NewsService{
            instance = Network.createService(NewsService::class.java)
            return instance as NewsService
        }

        fun removeInstance(){
            instance = null
        }
    }

    @GET("top-headlines/")
    fun getTopHeadline(@Query("country") country: String?,
                       @Query("apiKey") key: String?): Single<News>

    @GET("everything")
    fun getEverything(@Query("q") query: String?,
                      @Query("apiKey") key: String?): Single<News>

}