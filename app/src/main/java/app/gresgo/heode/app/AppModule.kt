package app.gresgo.heode.app

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import timber.log.Timber

object AppModule {

    fun create() = module {
        single<Timber.Tree> { Timber.DebugTree() }
        single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
        single<Gson> { GsonBuilder().create() }
    }

}