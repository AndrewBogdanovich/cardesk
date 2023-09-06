package com.example.cardesk.presentation.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentOtherBinding
import com.example.cardesk.presentation.navigateTo
import com.example.cardesk.presentation.setupToolbar

class OtherFragment : Fragment() {
    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "Other")
        binding.signInBtn.setOnClickListener {
            navigateTo(R.id.action_fragment_other_to_fragment_authorization)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}