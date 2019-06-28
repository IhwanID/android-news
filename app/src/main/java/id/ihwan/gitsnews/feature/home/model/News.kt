package id.ihwan.gitsnews.feature.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class News(
    var status: String = "" ,
    var totalResults: Int = 0,
    val articles: List<Articles>

){
    @Parcelize
    data class Articles(
            val source: Source = Source(),
            var author: String? = "",
            var title: String? = "",
            var description: String? = "",
            var url: String? = "",
            var urlToImage: String? = "",
            var publishedAt: String? = "",
            var content: String? = ""
    ) : Parcelable {
        @Parcelize
        data class Source(
            var name: String = ""
        ): Parcelable
    }
}