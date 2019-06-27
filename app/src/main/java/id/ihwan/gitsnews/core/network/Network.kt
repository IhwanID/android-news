package id.ihwan.gitsnews.core.network

import id.ihwan.gitsnews.BuildConfig
import id.ihwan.gitsnews.core.network.service.NewsService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


object Network {

    private val builder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor(ResponseHttpLogging())
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient: OkHttpClient.Builder by lazy {
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .followRedirects(false)
            .addNetworkInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val builderNew = chain.request().newBuilder()
                builderNew.addHeader("Accept", "application/json")
                builderNew.addHeader("Content-Type", "application/json")
                val requestNew = builderNew.build()
                chain.proceed(requestNew)
            }
    }

    var retrofit: Retrofit =
        builder.client(httpClient.build())
            .build()

    fun removeAllServices(){
        NewsService.removeInstance()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

}
