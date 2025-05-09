package com.arshtestproject.presentation.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arshtestproject.core.inrefaces.ICoroutineContextProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    protected open val contextProvider: ICoroutineContextProvider,
) : ViewModel() {

    private val job: Job = Job()

    private val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            onCoroutineError(exception)
        }

    protected abstract fun onCoroutineError(exception: Throwable)

    protected fun launchCoroutineIO(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(contextProvider.io) {
            block().runCatching { coroutineExceptionHandler }
        }
    }

    protected fun <T> asyncCoroutineIO(block: suspend CoroutineScope.() -> T): Deferred<T> {
        return viewModelScope.async(contextProvider.io) {
            block()
        }
    }

    protected fun pauseCoroutineIO(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(contextProvider.io) {
            block().runCatching { coroutineExceptionHandler }
        }
    }

    protected fun launchCoroutineMain(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(contextProvider.main) {
            block().runCatching { coroutineExceptionHandler }
        }
    }

    public override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
