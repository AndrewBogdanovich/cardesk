package com.example.cardesk.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentAdvertisementDetailBinding
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.presentation.util.DoubleClickListener
import com.example.cardesk.presentation.extension.displayBottomNavBar
import com.example.cardesk.presentation.extension.navigateTo
import com.example.cardesk.presentation.extension.setupToolbar
import com.example.cardesk.presentation.extension.show
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
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
        fetchingAd()
        binding.adsPhotoIv.setOnClickListener {
            openImageDetailView()
        }
        return binding.root
    }

    private fun fetchingAd() {
        lifecycleScope.launch {
            val adId = arguments?.getString("adsObjectId")
            adId?.let {
                viewModel.getAd(it)
            }
            viewModel.adById.collect { initView(it) }
        }
    }

    private fun openImageDetailView() {
        lifecycleScope.launch {
            val bundle = Bundle()
            val item = viewModel.adById.first()
            bundle.putString("imageUrl", item[0].photos)
            navigateTo(R.id.action_to_image_detail_fragment, bundle)
        }
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
        displayBottomNavBar(true)
        _binding = null
    }
}
