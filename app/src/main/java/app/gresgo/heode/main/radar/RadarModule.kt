package app.gresgo.heode.main.radar

import app.gresgo.heode.main.radar.domain.RadarRepository
import app.gresgo.heode.main.radar.domain.RadarRepositoryImpl
import app.gresgo.heode.main.radar.domain.RadarRepositoryTestImpl
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