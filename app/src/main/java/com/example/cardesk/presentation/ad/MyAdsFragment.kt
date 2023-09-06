package com.example.cardesk.presentation.ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.databinding.FragmentMyAdsBinding
import com.example.cardesk.presentation.setupToolbar

class MyAdsFragment : Fragment() {
    private var _binding: FragmentMyAdsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyAdsBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "My ads")
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}