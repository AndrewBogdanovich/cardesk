package com.example.cardesk.presentation.other.view.source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentCarValuationCalculatorBinding
import com.example.cardesk.presentation.setupToolbar

class CarValuationCalculatorFragment : Fragment() {
    private var _binding: FragmentCarValuationCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarValuationCalculatorBinding.inflate(inflater, container, false)
        setupToolbar(
            isShowing = true,
            isBackButtonEnabled = true,
            title = getString(R.string.car_valuation_calculator)
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}