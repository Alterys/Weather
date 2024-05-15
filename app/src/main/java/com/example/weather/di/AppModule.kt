package com.example.weather.di

import android.content.Context
import com.example.weather.common.Constants
import com.example.weather.data.remote.WeatherApi
import com.example.weather.data.repository.CityStorageRepositoryImpl
import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.domain.repository.CityStorageRepository
import com.example.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.internal.Provider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @WeatherRetrofit
    @Provides
    @Singleton
    fun provideWeatherRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(
        @WeatherRetrofit retrofit: Retrofit
    ): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: WeatherApi,
    ): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCityStorageRepository(
        @ApplicationContext context: Context
    ): CityStorageRepository {
        return CityStorageRepositoryImpl(context)
    }

}
