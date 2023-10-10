package com.example.cardesk.presentation.other.authorization

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentAuthorizationBinding
import com.example.cardesk.presentation.setupToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class AuthorizationFragment : Fragment() {
    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!
    private lateinit var vpAdapter: AuthViewPagerAdapter
    private val tabNames: Array<String> = arrayOf(
        "Login", "Register"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, isBackButtonEnabled = true, title = "Authorization")
        displayBottomNavBar(false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        vpAdapter = AuthViewPagerAdapter(this)
        binding.authViewPager.adapter = vpAdapter
        TabLayoutMediator(binding.authTabLayout, binding.authViewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }

    private fun displayBottomNavBar(isShowing: Boolean) {
        if (isShowing) {
            val navView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            navView?.visibility = View.VISIBLE
        } else {
            val navView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            navView?.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        displayBottomNavBar(true)
    }
}