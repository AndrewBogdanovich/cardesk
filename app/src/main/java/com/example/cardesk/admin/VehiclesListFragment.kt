package com.example.cardesk.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentVehiclesListBinding

class VehiclesListFragment : Fragment() {
    private var _binding: FragmentVehiclesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVehiclesListBinding.inflate(inflater, container, false)
        setupToolbar()
        binding.addVehicleFaBtn.setOnClickListener { addVehicleOnClick() }
        return binding.root
    }

    private fun setupToolbar(){
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "vehicle list page"
    }

    private fun addVehicleOnClick() {
//        parentFragmentManager.beginTransaction()
//            .setReorderingAllowed(true)
//            .replace(
//                R.id.nav_host_fragment,
//                AddVehicleFragment()
//            )
//            .addToBackStack("name")
//            .commit()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}