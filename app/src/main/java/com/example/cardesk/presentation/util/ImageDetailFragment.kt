package com.example.cardesk.presentation.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.cardesk.databinding.FragmentImageDetailBinding
import com.example.cardesk.presentation.extension.displayBottomNavBar
import com.example.cardesk.presentation.extension.setupToolbar

class ImageDetailFragment : Fragment() {

    private var _binding: FragmentImageDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentImageDetailBinding.inflate(layoutInflater, container, false)
        loadImage()
        binding.imageContainerIv.setOnClickListener(object : DoubleClickListener() {
            override fun onDoubleCLick(v: View) {
                binding.imageContainerIv.scaleX = 2f
                binding.imageContainerIv.scaleY = 2f
            }
        })
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupToolbar(isShowing = false)
        displayBottomNavBar(false)
    }

    private fun loadImage() {
        val imageId = arguments?.getString("imageUrl")
        binding.imageContainerIv.load(imageId) {
            crossfade(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        displayBottomNavBar(true)
        _binding = null
    }
}