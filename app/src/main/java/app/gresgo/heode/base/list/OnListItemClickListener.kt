package app.gresgo.heode.base.list

interface OnListItemClickListener<T, E> {

    fun onItemClick(data: T, extra: E?)

}