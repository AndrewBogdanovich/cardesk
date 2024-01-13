package com.example.cardesk.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.cardesk.R
import com.example.cardesk.data.network.model.AdvertisementResponse
import com.example.cardesk.databinding.FragmentAdvertisementDetailBinding
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.presentation.extension.displayBottomNavBar
import com.example.cardesk.presentation.extension.setupToolbar
import com.example.cardesk.presentation.extension.show
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat

class AdvertisementDetailFragment : Fragment() {
    private var _binding: FragmentAdvertisementDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<AdvertisementDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdvertisementDetailBinding.inflate(inflater, container, false)
        displayBottomNavBar(false)
        lifecycleScope.launch {
            val adId = arguments?.getString("adsObjectId")
            adId?.let {
                viewModel.getAd(it)
            }
            viewModel.adById.collect { initView(it) }
        }
        return binding.root
    }

    private fun initView(advertisement: List<AdvertisementModel>) {
        val title =
            advertisement[0].make + " " + advertisement[0].model + " " + advertisement[0].generation
        setupToolbar(isShowing = true, isBackButtonEnabled = true, title = title)
        setPrice(advertisement[0].price)
        setAdsPhoto(advertisement[0].photos)
        setParamsDescription(advertisement[0])
        setDescription(advertisement[0].description)
        setDateAndCity(advertisement[0].dateCreating, advertisement[0].city)
        binding.iconsLayout.show()
    }

    private fun setPrice(price: String) {
        binding.adsPriceTv.text = price
    }

    private fun setAdsPhoto(photoUrl: String) {
        binding.adsPhotoIv.load(photoUrl) {
            crossfade(true)
            placeholder(R.drawable.baseline_image_placeholder)
            transformations(RoundedCornersTransformation())
        }
    }

    private fun setParamsDescription(adItem: AdvertisementModel) {
        binding.adsParamsDescriptionEt.text =
            adItem.year + ", " + adItem.engineVolume + ", " + adItem.engineType + ", " + adItem.bodyType + ", " + adItem.mileage
    }

    private fun setDescription(description: String) {
        binding.descriptionTv.text = description
    }

    private fun setDateAndCity(dateCreating: String, city: String) {
        val date =
            SimpleDateFormat("dd MMMM yyyy").format(dateCreating.toLong())
        binding.adsCityAndDateTv.text = city + " : " + date
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        displayBottomNavBar(true)
    }
}