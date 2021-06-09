package app.gresgo.heode.main.team.list

import android.view.LayoutInflater
import android.view.ViewGroup
import app.gresgo.heode.base.list.BaseViewHolder
import app.gresgo.heode.core.model.User
import app.gresgo.heode.databinding.ItemUserBinding

class UserHolder(parent: ViewGroup): BaseViewHolder<User, Nothing, ItemUserBinding>(
    ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
) {

    override fun bind(data: User, extra: Nothing?) {
        binding.item = data
        binding.executePendingBindings()
    }

}