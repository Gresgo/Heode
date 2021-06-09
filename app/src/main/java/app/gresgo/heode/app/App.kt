package app.gresgo.heode.app

import android.app.Application
import app.gresgo.heode.core.network.NetworkModule
import app.gresgo.heode.main.login.LoginModule
import app.gresgo.heode.main.map.MapModule
import app.gresgo.heode.main.profile.ProfileModule
import app.gresgo.heode.main.radar.RadarModule
import app.gresgo.heode.main.team.TeamModule
import app.gresgo.heode.service.LocationModule
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
                NetworkModule.create(),
                LoginModule.create(),
                MapModule.create(),
                ProfileModule.create(),
                TeamModule.create(),
                RadarModule.create(),
                LocationModule.create()
            )
        }
        Timber.plant(get())
    }

}