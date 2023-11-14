package com.example.cardesk.presentation.other.view.source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentVehickeChecklistBinding
import com.example.cardesk.presentation.extension.setupToolbar

class VehicleCheckListFragment : Fragment() {
    private var _binding: FragmentVehickeChecklistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVehickeChecklistBinding.inflate(inflater, container, false)
        setupToolbar(
            isShowing = true,
            isBackButtonEnabled = true,
            title = getString(R.string.vehicle_check_list)
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}