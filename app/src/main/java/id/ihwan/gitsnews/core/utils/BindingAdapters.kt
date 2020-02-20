package id.ihwan.gitsnews.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("android:setImageFromUrl")
    fun setImageUrl(view: ImageView, url: String) {
        Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .into(view)
    }
}