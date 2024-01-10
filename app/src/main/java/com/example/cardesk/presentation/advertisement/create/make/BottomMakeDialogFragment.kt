package com.example.cardesk.presentation.advertisement.create.make

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardesk.R
import com.example.cardesk.databinding.BottomMakesSheetLayoutBinding
import com.example.cardesk.domain.model.MakesModel
import com.example.cardesk.presentation.advertisement.create.CreateAdvertisementViewModel
import com.example.cardesk.presentation.advertisement.create.CreateAdvertisementViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch

class BottomMakeDialogFragment : BottomSheetDialogFragment() {
    lateinit var binding: BottomMakesSheetLayoutBinding
    private var listener: BottomMakeListener? = null
    private val viewModel: CreateAdvertisementViewModel by viewModels { CreateAdvertisementViewModelFactory() }
    private lateinit var rvAdapter: MakesAdapter
    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    fun listener(listener: BottomMakeListener) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomMakesSheetLayoutBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            viewModel.makes.collect {
                setupRecyclerView(it)
            }
        }
        binding.closeFragment.setOnClickListener { dismiss() }
        return binding.root
    }

    private fun setupRecyclerView(data: List<MakesModel>) {
        rvAdapter = MakesAdapter()
        rvAdapter.setData(data)
        binding.makesRv.layoutManager = LinearLayoutManager(this.context)
        binding.makesRv.adapter = rvAdapter
        rvAdapter.setOnClickListener(object: MakesAdapter.OnClickListener{
            override fun onClick(position: Int, model: MakesModel) {
                saveSelectedMake(model.make)
            }
        })
    }

    private fun saveSelectedMake(data: String) {
        listener?.onDataReceived(data)
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        setupViewSize()
    }

    private fun setupViewSize() {
        dialog?.let {
            val bottomSheet =
                it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            val behavior = BottomSheetBehavior.from(bottomSheet)

            binding.root.layoutParams.height =
                (Resources.getSystem().displayMetrics.heightPixels * 0.7).toInt()
            behavior.peekHeight = (Resources.getSystem().displayMetrics.heightPixels * 0.8).toInt()
        }
    }

    interface BottomMakeListener {
        fun onDataReceived(data: String)
    }
}