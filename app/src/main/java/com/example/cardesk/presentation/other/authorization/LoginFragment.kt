package com.example.cardesk.presentation.other.authorization

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentLoginBinding
import com.example.cardesk.presentation.navigateTo

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var isShowingPassword = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.forgotPasswordTv.setOnClickListener {
            toForgotPasswordScreen()
        }
        binding.loginPasswordLayout.setEndIconOnClickListener {
            if (!isShowingPassword) {
                binding.loginPasswordEt.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                isShowingPassword = true
            } else {
                binding.loginPasswordEt.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                isShowingPassword = false
            }
        }
        return binding.root
    }

    private fun toForgotPasswordScreen() {
        navigateTo(R.id.action_fragment_authorization_to_forgotPasswordFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}