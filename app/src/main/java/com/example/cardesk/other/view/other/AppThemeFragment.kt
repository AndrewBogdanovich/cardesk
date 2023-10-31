package com.example.cardesk.other.view.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentAppThemeBinding
import com.example.cardesk.setupToolbar

class AppThemeFragment: Fragment() {
    private var _binding: FragmentAppThemeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAppThemeBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, isBackButtonEnabled = true, title = getString(R.string.app_theme))
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}