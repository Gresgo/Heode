package app.gresgo.heode.utils.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import app.gresgo.heode.R
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imageUrl"])
fun loadImage(view: ImageView, imageUrl: String?) {
//    if (imageUrl.isNullOrEmpty()) {
//        return
//    } else {
        Glide.with(view)
            .load(imageUrl)
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder)
            .into(view)
//    }
}