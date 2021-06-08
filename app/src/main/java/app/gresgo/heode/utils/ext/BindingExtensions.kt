package app.gresgo.heode.utils.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imageUrl"])
fun loadImage(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        return
    } else {
        Glide.with(view).load(imageUrl).into(view)
    }
}