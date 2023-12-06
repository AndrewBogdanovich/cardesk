package com.example.cardesk.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.cardesk.R
import com.example.cardesk.databinding.AdvertisementItemBinding
import java.text.SimpleDateFormat

class AdsAdapter : RecyclerView.Adapter<AddsViewHolder>() {
    private val adapterData = mutableListOf<com.example.cardesk.domain.model.AdvertisementModel>()
    private var onClickListener: OnClickListener? = null
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
                    this.make + " " + this.model + " " + this.generation
                binding.adsPriceTv.text = this.price
                binding.adsPhotoIv.load(this.photos) {
                    crossfade(true)
                    placeholder(R.drawable.baseline_image_placeholder)
                    transformations(RoundedCornersTransformation())
                }
                binding.adsParamsDescriptionEt.text =
                    this.year + ", " + this.transmission + ", " + this.engineVolume + ", " + this.engineType + ", " + this.bodyType + ", " + this.mileage

                val date = SimpleDateFormat("dd MMMM yyyy").format(this.dateCreating.toLong())
                binding.adsCityAndDateTv.text =
                    this.city + " : " + date
            }
        }
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, adapterData[position])
            }
        }
    }

    fun setData(data: List<com.example.cardesk.domain.model.AdvertisementModel>) {
        adapterData.apply {
            clear()
            addAll(data)
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: com.example.cardesk.domain.model.AdvertisementModel)
    }
}

class AddsViewHolder(val binding: AdvertisementItemBinding) : RecyclerView.ViewHolder(binding.root)
