package com.choward.features.view

import FeaturesAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.choward.features.databinding.FeaturesDisplayLayoutBinding
import com.choward.features.model.remote.FeaturesBusiness
import com.choward.features.model.remote.FeaturesResponse
import com.choward.features.viewmodel.FeaturesViewModel

class DisplayBusinessesFragment:Fragment() {

    private lateinit var binding: FeaturesDisplayLayoutBinding
    private val viewModel: FeaturesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FeaturesDisplayLayoutBinding.inflate(inflater,container,false)
        viewModel.doSearch("black-owned", "Atlanta")
        viewModel.businesses.observe(viewLifecycleOwner){
            updateView(it)
        }
        return binding.root
    }

    private fun updateView(data: FeaturesResponse) {
        binding.apply {
            rvFeaturesResults.layoutManager = LinearLayoutManager(context)
            rvFeaturesResults.adapter = FeaturesAdapter(data)
        }
    }


}