package app.gresgo.heode.base.domain

import app.gresgo.heode.core.model.ErrorResponse
import com.google.gson.Gson
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import retrofit2.Response

abstract class NetworkRepository: KoinComponent {

    /**
     * this method run only in Dispatchers.IO context
     * and exceptions are handled too, so we can suppress it
     **/
    @Suppress("BlockingMethodInNonBlockingContext")
    protected fun <T> Response<T>.getResponseBody(): T {
        if (!isSuccessful) {
            val message = try {
                val error = get<Gson>().fromJson(errorBody()?.string(), ErrorResponse::class.java)
                error.error
            } catch (e: Exception) {
                "Unexpected error"
            }
            throw Exception(message)
        }
        return body() ?: throw NullPointerException("Unexpected error")
    }

}