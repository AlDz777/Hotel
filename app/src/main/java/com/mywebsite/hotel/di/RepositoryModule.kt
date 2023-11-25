package com.mywebsite.hotel.di

import com.mywebsite.hotel.data.repository.HotelRepositoryImpl
import com.mywebsite.hotel.data.storage.network.ApiService
import com.mywebsite.hotel.repository.HotelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideHotelRepository(apiService: ApiService) : HotelRepository {
        return HotelRepositoryImpl(apiService = apiService)
    }
}