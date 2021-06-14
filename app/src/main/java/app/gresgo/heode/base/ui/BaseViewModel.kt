package app.gresgo.heode.base.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import timber.log.Timber
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel: ViewModel() {

    val isLoading = ObservableField(true)
    val onError = MutableStateFlow<String?>(null)

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
            Timber.i("get error ${throwable.message}")
            launchJob {
                onError.value = (throwable.message.toString())
            }
        }
    }

}