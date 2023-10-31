package com.example.cardesk.presentation.advertisement

import android.os.Bundle
import android.text.Editable
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
import com.example.cardesk.databinding.FragmentCreateAdvertisementBinding
import com.example.cardesk.presentation.setupToolbar

class CreateAdvertisementFragment : Fragment(),
    BottomDescriptionFragment.BottomDescriptionListener {

    private var _binding: FragmentCreateAdvertisementBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAdvertisementBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "New advertisement", isBackButtonEnabled = true)
        binding.descriptionEt.setOnClickListener {
            showBottomSheetFragment()
        }
        binding.chosePhotoBtn.setOnClickListener { selectPhoto() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
    }

    private fun selectPhoto() {

    }

    private fun showBottomSheetFragment() {
        val bundle = Bundle()
        bundle.putString("adsDescription", binding.descriptionEt.text.toString())
        val bsdf = BottomDescriptionFragment()
        bsdf.arguments = bundle
        bsdf.listener(this)
        bsdf.show(childFragmentManager, "tag")
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_clear_ads_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDataReceived(data: Editable) {
        binding.descriptionEt.text = data
    }
}