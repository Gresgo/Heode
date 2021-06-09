package app.gresgo.heode.utils.ext

import kotlinx.coroutines.flow.MutableStateFlow

fun <T>MutableStateFlow<ArrayList<T>>.notifyChanged() {
    this.value = this.value
}