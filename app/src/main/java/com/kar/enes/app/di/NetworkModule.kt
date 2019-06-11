package com.kar.enes.app.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kar.enes.app.BuildConfig
import com.kar.enes.app.data.remote.ApiHelper
import com.kar.enes.app.utils.Urls
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by M.Enes on 5/8/2019
 */
@Module
class NetworkModule {


    @Provides
    @Singleton
    internal fun provideHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.retryOnConnectionFailure(true)
        builder.addInterceptor(logger)
        builder.cache(cache)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.readTimeout(60, TimeUnit.SECONDS)
        return builder.build()
    }

    @Provides
    @Singleton
    internal fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    internal fun provideCache(file: File): Cache {
        return Cache(file, (10 * 1024 * 1024).toLong())
    }

    @Provides
    @Singleton
    internal fun provideCacheFile(context: Context): File {
        return context.filesDir
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideGsonClient(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    internal fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    internal fun provideApiService(
        client: OkHttpClient,
        gson: GsonConverterFactory,
        rxAdapter: RxJava2CallAdapterFactory
    ): ApiHelper {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(Urls.BASE_URL)
            .addConverterFactory(gson)
            .addCallAdapterFactory(rxAdapter)
            .build()

        return retrofit.create(ApiHelper::class.java)
    }
}