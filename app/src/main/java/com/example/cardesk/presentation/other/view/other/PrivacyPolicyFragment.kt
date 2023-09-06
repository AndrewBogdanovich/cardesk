package com.example.cardesk.presentation.other.view.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentPrivacyPolicyBinding
import com.example.cardesk.presentation.setupToolbar

class PrivacyPolicyFragment: Fragment() {
    private var _binding: FragmentPrivacyPolicyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrivacyPolicyBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, isBackButtonEnabled = true, title = getString(R.string.privacy_policy))
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}