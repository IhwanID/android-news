package id.ihwan.gitsnews.core.network.service

import id.ihwan.gitsnews.core.network.response.ArticleListResponse
import id.ihwan.gitsnews.core.network.response.SourceListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines/")
    fun getTopHeadline(@Query("country") country: String?): Single<ArticleListResponse>

    @GET("everything")
    fun getEverything(@Query("q") query: String? = "jokowi",
                      @Query("page") page: Int? = 1): Single<ArticleListResponse>

    @GET("sources")
    fun getSources(): Single<SourceListResponse>

}