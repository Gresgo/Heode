package app.gresgo.heode.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

const val BASE_URL = "https://saveindb-ls.herokuapp.com/"

const val LOCATION_CHANNEL_ID = "app.gresgo.heode.notifications.LOCATION"

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}
