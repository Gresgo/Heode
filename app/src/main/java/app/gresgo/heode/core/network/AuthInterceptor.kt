package app.gresgo.heode.core.network

import android.content.SharedPreferences
import app.gresgo.heode.utils.PreferenceKeys
import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class AuthInterceptor: Interceptor, KoinComponent {

    private val preferences: SharedPreferences by inject()

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val token = preferences.getString(PreferenceKeys.TOKEN, null)

        val request = original.newBuilder().apply {
            token?.let { header("Authorization", "Token $it") }
            method(original.method(), original.body())
        }.build()

        val response = chain.proceed(request)
        val code = response.code()
        Timber.i("response code $code")
        if (code == 401) {
            preferences.edit()
                .putString(PreferenceKeys.TOKEN, null)
                .apply()
        }
        return response
    }

}