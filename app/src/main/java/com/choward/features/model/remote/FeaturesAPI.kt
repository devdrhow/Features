package com.choward.features.model.remote


import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface FeaturesAPI {
    @GET(BASE_SEARCH)
   suspend  fun getAllBusinesses(
        @Header("Authorization") authHeader: String,
        @Query("term") searchTerm: String,
        @Query("location") location:String): FeaturesResponse
    @GET(BASE_SEARCH)
    suspend fun getBusinessInfo(): FeaturesBusiness
//    @GET(LOCATION)
//    suspend fun getBusinessAddress(): FeaturesLocations
}