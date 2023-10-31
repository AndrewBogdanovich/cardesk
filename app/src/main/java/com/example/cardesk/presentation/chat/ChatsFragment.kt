package com.example.cardesk.presentation.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentChatsBinding
import com.example.cardesk.presentation.navigateTo
import com.example.cardesk.presentation.setupToolbar

class ChatsFragment: Fragment() {
    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "Chats")
        binding.chatsLoginBtn.setOnClickListener { navigateTo(R.id.action_fragment_chats_to_fragment_authorization) }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}