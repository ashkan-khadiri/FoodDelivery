package com.arshtestproject.core.inrefaces

import kotlinx.coroutines.CoroutineDispatcher


interface ICoroutineContextProvider {
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
