package com.choward.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import com.choward.features.R
import com.choward.features.model.remote.API_KEY
import com.choward.features.model.remote.FeaturesNetwork
import com.choward.features.model.remote.FeaturesResponse
import com.choward.features.viewmodel.FeaturesViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit var btnTest: Button

    val viewModel: FeaturesViewModel by lazy {
        FeaturesViewModel()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.doSearch()
        initViews()

    }

    fun initViews(){
        btnTest = findViewById(R.id.testButton)
        btnTest.setOnClickListener {
            viewModel.doSearch()
        }
    }






}