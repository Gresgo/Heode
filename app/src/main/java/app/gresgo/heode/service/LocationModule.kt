package app.gresgo.heode.service

import app.gresgo.heode.service.domain.LocationRepository
import app.gresgo.heode.service.domain.LocationRepositoryImpl
import app.gresgo.heode.service.ui.LocationViewModel
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object LocationModule {

    fun create() = module {
        single<LocationRepository> { LocationRepositoryImpl(get()) }
        single { LocationViewModel(get()) }
        single { LocationServices.getFusedLocationProviderClient(androidContext()) }


    }

}