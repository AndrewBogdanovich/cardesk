package com.example.cardesk.presentation.advertisement

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cardesk.R
import com.example.cardesk.databinding.BottomDescriptionSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomDescriptionFragment : BottomSheetDialogFragment() {
    lateinit var binding: BottomDescriptionSheetLayoutBinding
    private var listener: BottomDescriptionListener? = null
    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    fun listener(listener: BottomDescriptionListener){
        this.listener = listener
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomDescriptionSheetLayoutBinding.inflate(layoutInflater, container, false)
        binding.closeFragment.setOnClickListener {
            dismiss()
        }
        binding.saveBtn.setOnClickListener {
            saveDescriptionText()
        }
        return binding.root
    }

    private fun saveDescriptionText() {
        val descriptionText = binding.descriptionEt.text
        listener?.onDataReceived(descriptionText)
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val bottomSheet =
                it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            val behavior = BottomSheetBehavior.from(bottomSheet)

            binding.root.layoutParams.height =
                (Resources.getSystem().displayMetrics.heightPixels * 0.7).toInt()
            behavior.peekHeight = (Resources.getSystem().displayMetrics.heightPixels * 0.8).toInt()
        }
    }

    interface BottomDescriptionListener{
        fun onDataReceived(data: Editable)
    }
}

