package id.ihwan.gitsnews.feature.home.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

    @Parcelize
    data class Articles(
            val source: Source = Source(),
            var author: String? = "",
            var title: String? = "",
            var description: String? = "",
            var url: String? = "",
            var urlToImage: String? = "",
            var publishedAt: String = "",
            var content: String? = ""
    ) : Parcelable {
        @Parcelize
        data class Source(
            var name: String = ""
        ): Parcelable

        @SuppressLint("SimpleDateFormat")
        fun getDate() : String{

            val newDate = publishedAt

            val sdf = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
            try {
                val result: Date = sdf.parse(newDate)
                val date = SimpleDateFormat("dd MMM yyyy")
                return date.format(result)
            }catch (e : Exception){
                e.printStackTrace()
            }

            return newDate
        }
    }
