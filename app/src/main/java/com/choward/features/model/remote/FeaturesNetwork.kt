package com.choward.features.model.remote

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val TAG = "FeaturesNetwork"
object FeaturesNetwork {
    val featuresAPI: FeaturesAPI by lazy {
        initRetrofit()
    }

    private fun initRetrofit(): FeaturesAPI {
        Log.d(TAG, "FeaturesNetwork: retro")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    private fun createClient(): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }


}