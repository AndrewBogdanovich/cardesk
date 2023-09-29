package com.example.cardesk.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.cardesk.R
import com.example.cardesk.data.network.model.AdvertisementResponse
import com.example.cardesk.databinding.AdvertisementItemBinding

class AdsAdapter : RecyclerView.Adapter<AddsViewHolder>() {
    private val adapterData = mutableListOf<AdvertisementResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddsViewHolder {
        val binding =
            AdvertisementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddsViewHolder(binding)
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: AddsViewHolder, position: Int) {
        with(holder) {
            with(adapterData[position]) {
                binding.adsVehicleTitleTv.text =
                    this.mark + " " + this.model + " " + this.generation
                binding.adsPriceTv.text = this.price
                binding.adsPhotoIv.load(this.photos){
                    crossfade(true)
                    placeholder(R.drawable.baseline_image_placeholder)
                    transformations(CircleCropTransformation())
                }
                binding.adsDescriptionEt.text =
                    this.year + ", " + this.transmission + ", " + this.engineVolume + ", " + this.engineType + ", " + this.bodyType + ", " + this.mileage
                binding.adsCityAndDateTv.text = this.city
            }
        }
    }

    fun setData(data: List<AdvertisementResponse>) {
        adapterData.apply {
            clear()
            addAll(data)
        }
    }
}

class AddsViewHolder(val binding: AdvertisementItemBinding) : RecyclerView.ViewHolder(binding.root)
