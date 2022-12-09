package com.choward.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import com.choward.features.R
import com.choward.features.model.remote.API_KEY
import com.choward.features.model.remote.FeaturesNetwork
import com.choward.features.model.remote.FeaturesResponse
import com.choward.features.view.DisplayBusinessesFragment
import com.choward.features.view.SearchFragment
import com.choward.features.viewmodel.FeaturesViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            replace(R.id.features_fragment_placeholder, DisplayBusinessesFragment())
            replace(R.id.frag_search_bar, SearchFragment())
        }
    }

    }


