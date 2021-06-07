package app.gresgo.heode.app

import android.app.Application
import app.gresgo.heode.core.network.NetworkModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                AppModule.create(),
                NetworkModule.create()
            )
        }
        Timber.plant(get())
    }

}