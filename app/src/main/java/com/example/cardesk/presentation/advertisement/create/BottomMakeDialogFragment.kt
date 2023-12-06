package com.example.cardesk.presentation.advertisement.create

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.cardesk.R
import com.example.cardesk.databinding.BottomMakesSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch

class BottomMakeDialogFragment : BottomSheetDialogFragment() {
    lateinit var binding: BottomMakesSheetLayoutBinding
    private var listener: BottomMakeListener? = null
    private val viewModel: CreateAdvertisementViewModel by viewModels()
    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    fun listener(listener: BottomMakeListener) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomMakesSheetLayoutBinding.inflate(inflater, container, false)
        loadMakes()
        viewModel.makes.observe(this) {
            val result = it
        }
        binding.saveBtn.setOnClickListener { saveSelectedMake() }
        return binding.root
    }

    private fun loadMakes() {
        viewModel.viewModelScope.launch {
            viewModel.loadMakes()
        }
    }

    private fun saveSelectedMake() {
        listener?.onDataReceived("Audi")
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