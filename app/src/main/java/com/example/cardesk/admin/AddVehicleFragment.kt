package com.example.cardesk.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cardesk.databinding.FragmentAddVehicleBinding
import com.example.cardesk.network.RetrofitClient
import com.example.cardesk.network.helper.VehicleApiImpl
import com.example.cardesk.network.model.VehicleRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddVehicleFragment : Fragment() {
    private var _binding: FragmentAddVehicleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddVehicleBinding.inflate(inflater, container, false)
        setupToolbar()
        binding.addCarBtn.setOnClickListener { addVehicle() }
        return binding.root
    }

    private fun setupToolbar(){
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "add vehicle page"
    }

    private fun addVehicle() {
        val model = VehicleRequest(
            mark = binding.markEt.text.toString(),
            model = binding.modelEt.text.toString(),
            generation = binding.generationEt.text.toString()
        )
        val vehicleApiHelper = VehicleApiImpl(RetrofitClient.vehicleApiService)
        GlobalScope.launch {
            vehicleApiHelper.addVehicle(model)
        }
        parentFragmentManager.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}