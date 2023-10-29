package com.example.cardesk.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentAdvertisementDetailBinding
import com.example.cardesk.presentation.setupToolbar
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

class AdvertisementDetailFragment : Fragment() {

    private var _binding: FragmentAdvertisementDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AdvertisementDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdvertisementDetailBinding.inflate(inflater, container, false)
        viewModel.viewModelScope.launch {
            val adsId = arguments?.getString("adsObjectId")
            adsId?.let {
                val adsObject = viewModel.getAds(it)
                val title =
                    adsObject[0].mark + " " + adsObject[0].model + " " + adsObject[0].generation
                setupToolbar(isShowing = true, isBackButtonEnabled = true, title = title)
                binding.adsPriceTv.text = adsObject[0].price
                binding.adsPhotoIv.load(adsObject[0].photos) {
                    crossfade(true)
                    placeholder(R.drawable.baseline_image_placeholder)
                    transformations(RoundedCornersTransformation())
                }
                binding.adsParamsDescriptionEt.text =
                    adsObject[0].year + ", " + adsObject[0].engineVolume + ", " + adsObject[0].engineType + ", " + adsObject[0].bodyType + ", " + adsObject[0].mileage
                binding.descriptionTv.text = adsObject[0].description
                val date =
                    SimpleDateFormat("dd MMMM yyyy").format(adsObject[0].dateCreating.toLong())
                binding.adsCityAndDateTv.text = adsObject[0].city + " : " + date
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}