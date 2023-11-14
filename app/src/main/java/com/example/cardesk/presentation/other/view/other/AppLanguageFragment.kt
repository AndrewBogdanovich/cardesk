package com.example.cardesk.presentation.other.view.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentAppLanguageBinding
import com.example.cardesk.presentation.extension.setupToolbar

class AppLanguageFragment : Fragment() {
    private var _binding: FragmentAppLanguageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAppLanguageBinding.inflate(inflater, container, false)
        setupToolbar(
            isShowing = true,
            isBackButtonEnabled = true,
            title = getString(R.string.app_language)
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}