package app.gresgo.heode.main.team.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.gresgo.heode.base.list.OnListItemClickListener
import app.gresgo.heode.core.model.User

class UsersAdapter(
    private val listener: OnListItemClickListener<User, Nothing>? = null
): RecyclerView.Adapter<UserHolder>() {

    private val items: ArrayList<User> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun update(data: List<User>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

}