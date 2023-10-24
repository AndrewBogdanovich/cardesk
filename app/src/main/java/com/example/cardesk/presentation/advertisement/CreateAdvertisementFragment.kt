package com.example.cardesk.presentation.advertisement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.databinding.FragmentCreateAdvertisementBinding
import com.example.cardesk.presentation.setupToolbar

class CreateAdvertisementFragment: Fragment() {

    private var _binding: FragmentCreateAdvertisementBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAdvertisementBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "New advertisement", isBackButtonEnabled = true)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}