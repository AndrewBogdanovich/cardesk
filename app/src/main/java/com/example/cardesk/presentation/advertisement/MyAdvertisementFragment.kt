package com.example.cardesk.presentation.advertisement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentMyAdvertisementBinding
import com.example.cardesk.presentation.navigateTo
import com.example.cardesk.presentation.setupToolbar

class MyAdvertisementFragment : Fragment() {
    private var _binding: FragmentMyAdvertisementBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyAdvertisementBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "My ads")
        binding.myadsLoginBtn.setOnClickListener { navigateTo(R.id.action_fragment_my_ads_to_fragment_authorization) }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}