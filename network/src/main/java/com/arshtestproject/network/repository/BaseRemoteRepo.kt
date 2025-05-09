package com.arshtestproject.network.repository

import com.arshtestproject.core.inrefaces.repo.IBaseRepo
import retrofit2.Call


abstract class BaseRemoteRepo() : IBaseRepo {

    fun <T> getResponse(call: Call<T>): T? {
        return call.execute().body()
    }
}