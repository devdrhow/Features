package com.choward.features.viewmodel

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.choward.features.model.remote.API_KEY
import com.choward.features.model.remote.FeaturesBusiness
import com.choward.features.model.remote.FeaturesNetwork
import com.choward.features.model.remote.FeaturesResponse
import kotlinx.coroutines.*

private const val TAG = "FeaturesViewModel"

class FeaturesViewModel : ViewModel() {

    private val _businesses = MutableLiveData<FeaturesResponse>()
    val businesses: LiveData<FeaturesResponse>
        get() = _businesses

    private val exHandler = CoroutineExceptionHandler { coroutineContext, throwable ->

    }

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main + exHandler)

    private val currentDispatcher = Dispatchers.IO


    init {

        doSearch("black-owned", "Atlanta")

    }

    fun doSearch(searchTerm: String, location: String) {
        Log.d(TAG, "init: inside")
        coroutineScope.launch {
            Log.d(TAG, "onCreate: launch")
            val featuresResponse = FeaturesNetwork.featuresAPI.getAllBusinesses(
                "Bearer $API_KEY", searchTerm,location
            )
            Log.d(TAG, "onCreate: feat")

            if (featuresResponse.isSuccessful) {
                Log.d(TAG, "onCreate: in Success")
                featuresResponse.body()?.let {
                    _businesses.value = it
                    Log.d(TAG, "Success value: $it")
                }

            } else {
                Log.d(TAG, "onCreate: Failed")
            }
        }
    }

}