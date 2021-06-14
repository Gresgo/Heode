package app.gresgo.heode.main.radar

import app.gresgo.heode.main.radar.data.RadarRepository
import app.gresgo.heode.main.radar.data.RadarRepositoryTestImpl
import app.gresgo.heode.main.radar.ui.RadarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object RadarModule {

    fun create() = module {
//        single<RadarRepository> { RadarRepositoryImpl(get()) }
        single<RadarRepository> { RadarRepositoryTestImpl() }
        viewModel { RadarViewModel(get()) }
    }

}