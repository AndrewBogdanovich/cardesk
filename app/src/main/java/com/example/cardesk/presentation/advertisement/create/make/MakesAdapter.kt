package com.example.cardesk.presentation.advertisement.create.make

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardesk.databinding.MakeItemBinding
import com.example.cardesk.domain.model.MakesModel

class MakesAdapter : RecyclerView.Adapter<MakesViewHolder>() {
    private val adapterData = mutableListOf<MakesModel>()
    private var onClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakesViewHolder {
        val binding = MakeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakesViewHolder(binding)
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: MakesViewHolder, position: Int) {
        holder.binding.makeItemTv.text = adapterData[position].make
        holder.itemView.setOnClickListener {
            if (onClickListener!=null){
                onClickListener!!.onClick(position, adapterData[position])
            }
        }
    }

    fun setData(data: List<MakesModel>) {
        adapterData.apply {
            clear()
            addAll(data)
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: MakesModel)
    }
}

class MakesViewHolder(val binding: MakeItemBinding) : RecyclerView.ViewHolder(binding.root)

