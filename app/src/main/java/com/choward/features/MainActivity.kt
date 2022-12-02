package com.choward.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import com.choward.features.model.remote.API_KEY
import com.choward.features.model.remote.FeaturesNetwork
import com.choward.features.model.remote.FeaturesResponse
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)
    
    

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        
        coroutineScope.launch {
            Log.d(TAG, "onCreate: launch")
            val featuresResponse = FeaturesNetwork.featuresAPI.getAllBusinesses("Bearer $API_KEY","black-owned","Atlanta")
            Log.d(TAG, "onCreate: feat")
            
            if (featuresResponse.businesses.isNotEmpty()) {
                Log.d(TAG, "onCreate: ${featuresResponse.businesses}")
            }
            else {
                Log.d(TAG, "onCreate: Failed")
            }
        }
        
    }




}