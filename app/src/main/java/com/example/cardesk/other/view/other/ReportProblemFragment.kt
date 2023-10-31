package com.example.cardesk.other.view.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentReportProblemBinding
import com.example.cardesk.setupToolbar

class ReportProblemFragment: Fragment() {
    private var _binding: FragmentReportProblemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReportProblemBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, isBackButtonEnabled = true, title = getString(R.string.report_a_problem))
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}