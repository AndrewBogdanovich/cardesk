package com.example.cardesk.presentation.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentBookmarksBinding
import com.example.cardesk.presentation.navigateTo
import com.example.cardesk.presentation.setupToolbar

class BookmarksFragment : Fragment() {
    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "Bookmarks")
        binding.bookmarksLoginBtn.setOnClickListener { navigateTo(R.id.action_fragment_bookmarks_to_fragment_authorization) }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}