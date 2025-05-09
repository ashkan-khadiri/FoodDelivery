package com.arshtestproject.di

import com.arshtestproject.commen.AppConstant
import com.arshtestproject.network.api.food_api.FoodApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit
        .Builder()
        .baseUrl(AppConstant.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Singleton
    @Provides
    fun provideFoodRecipeRemoteRepo(
        retrofit: Retrofit,
    ): FoodApi {
        return retrofit.create(FoodApi::class.java)
    }
}