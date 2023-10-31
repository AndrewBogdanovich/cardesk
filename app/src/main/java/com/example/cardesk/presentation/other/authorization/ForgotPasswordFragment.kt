package com.example.cardesk.presentation.other.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentForgotPasswordBinding
import com.example.cardesk.presentation.displayBottomNavBar
import com.example.cardesk.presentation.setupToolbar

class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        setupToolbar(
            isShowing = true,
            isBackButtonEnabled = true,
            title = getString(R.string.forgot_password)
        )
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        displayBottomNavBar(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}