package com.choward.features.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.choward.features.databinding.SearchFragmentLayoutBinding
import com.choward.features.viewmodel.FeaturesViewModel
import java.util.zip.Inflater

class SearchFragment: Fragment() {

    private lateinit var binding: SearchFragmentLayoutBinding
    private val viewModel: FeaturesViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = SearchFragmentLayoutBinding.inflate(inflater,container,false)

        return binding.root
    }


}