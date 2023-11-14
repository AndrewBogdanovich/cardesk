package com.example.cardesk.presentation.advertisement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentMyAdvertisementBinding
import com.example.cardesk.presentation.extension.navigateTo
import com.example.cardesk.presentation.extension.setupToolbar

class MyAdvertisementFragment : Fragment() {
    private var _binding: FragmentMyAdvertisementBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyAdvertisementBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "My ads")
        binding.myadsLoginBtn.setOnClickListener { navigateTo(R.id.action_fragment_my_ads_to_fragment_authorization) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
    }

    private fun setupMenu(){
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_ads_icon_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                navigateTo(R.id.action_fragment_my_ads_to_createAdvertisementFragment)
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}