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
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentCreateAdvertisementBinding
import com.example.cardesk.presentation.extension.setupToolbar

class CreateAdvertisementFragment : Fragment(),
    BottomDescriptionDialogFragment.BottomDescriptionListener,
    BottomMakeDialogFragment.BottomMakeListener {
    private var _binding: FragmentCreateAdvertisementBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateAdvertisementViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAdvertisementBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "New advertisement", isBackButtonEnabled = true)
        binding.descriptionEt.setOnClickListener {
            showDescriptionEditor()
        }
        binding.selectMake.setOnClickListener {
            showMakeSelector()
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

    private fun showMakeSelector() {
        val myFrag = BottomMakeDialogFragment()
        myFrag.listener(this)
        myFrag.show(childFragmentManager, "tag1")
    }

    private fun showDescriptionEditor() {
        val bundle = Bundle()
        bundle.putString("adsDescription", binding.descriptionEt.text.toString())
        val myFrag = BottomDescriptionDialogFragment()
        myFrag.arguments = bundle
        myFrag.listener(this)
        myFrag.show(childFragmentManager, "tag")
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

    override fun onDataReceived(data: String) {
        binding.selectedMakeTv.text = data
    }
}