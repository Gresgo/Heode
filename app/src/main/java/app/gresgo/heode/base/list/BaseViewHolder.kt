package app.gresgo.heode.base.list

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T, E, B: ViewBinding>(
    val binding: B
): RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(data: T, extra: E? = null)

}