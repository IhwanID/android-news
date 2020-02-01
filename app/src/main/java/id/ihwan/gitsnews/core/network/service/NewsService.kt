package id.ihwan.gitsnews.core.network.service

import id.ihwan.gitsnews.feature.home.model.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines/")
    fun getTopHeadline(@Query("country") country: String?,
                       @Query("apiKey") key: String?): Single<News>

    @GET("everything")
    fun getEverything(@Query("q") query: String?,
                      @Query("apiKey") key: String?): Single<News>

}