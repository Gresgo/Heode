package app.gresgo.heode.main.map

import app.gresgo.heode.main.map.domain.MapRepository
import app.gresgo.heode.main.map.domain.MapRepositoryImpl
import app.gresgo.heode.main.map.ui.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MapModule {

    fun create() = module {
        single<MapRepository> { MapRepositoryImpl(get()) }
        viewModel { MapViewModel(get()) }
    }

}