package app.gresgo.heode.main.radar

import app.gresgo.heode.main.radar.domain.RadarRepository
import app.gresgo.heode.main.radar.domain.RadarRepositoryImpl
import org.koin.dsl.module

object RadarModule {

    fun create() = module {
        single<RadarRepository> { RadarRepositoryImpl(get()) }
    }

}