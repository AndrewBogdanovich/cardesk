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
import com.example.cardesk.data.network.model.AdvertisementResponse
import com.example.cardesk.databinding.FragmentAdvertisementDetailBinding
import com.example.cardesk.presentation.displayBottomNavBar
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
        displayBottomNavBar(false)
        viewModel.viewModelScope.launch {
            val adsId = arguments?.getString("adsObjectId")
            adsId?.let {
                val adsObject = viewModel.getAds(it)
                initView(adsObject)
            }
        }
        return binding.root
    }

    private fun initView(advertisement: List<AdvertisementResponse>) {
        val title =
            advertisement[0].mark + " " + advertisement[0].model + " " + advertisement[0].generation
        setupToolbar(isShowing = true, isBackButtonEnabled = true, title = title)
        binding.adsPriceTv.text = advertisement[0].price
        binding.adsPhotoIv.load(advertisement[0].photos) {
            crossfade(true)
            placeholder(R.drawable.baseline_image_placeholder)
            transformations(RoundedCornersTransformation())
        }
        binding.adsParamsDescriptionEt.text =
            advertisement[0].year + ", " + advertisement[0].engineVolume + ", " + advertisement[0].engineType + ", " + advertisement[0].bodyType + ", " + advertisement[0].mileage
        binding.descriptionTv.text = advertisement[0].description
        val date =
            SimpleDateFormat("dd MMMM yyyy").format(advertisement[0].dateCreating.toLong())
        binding.adsCityAndDateTv.text = advertisement[0].city + " : " + date
        binding.iconsLayout.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        displayBottomNavBar(true)
    }
}