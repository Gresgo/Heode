package app.gresgo.heode.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class BaseViewModel: ViewModel() {

    val isLoading = ObservableField(true)

    protected fun launchJob(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(context + createErrorHandler(), start, block)

    protected fun launchLoadingJob(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(context + createErrorHandler(), start) {
        isLoading.set(true)
        try {
            block()
        } finally {
            isLoading.set(false)
        }
    }

    private fun createErrorHandler() = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
        if (throwable !is CancellationException) {
//            onError.postCall(throwable)
        }
    }

}