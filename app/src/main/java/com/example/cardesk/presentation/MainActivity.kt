package com.example.cardesk.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.cardesk.R
import com.example.cardesk.databinding.ActivityMainBinding
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.VehicleApiImpl
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setSupportActionBar(binding.appToolbar)
        setupAppCenter()
        setupNavigationController()
    }

    private fun setupNavigationController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationView.apply {
            navController.let { navController ->
                NavigationUI.setupWithNavController(this, navController)
                setOnItemSelectedListener { item ->
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                setOnItemReselectedListener {
                    navController.popBackStack(destinationId = it.itemId, inclusive = false)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setupAppCenter() {
        AppCenter.start(
            application,
            "49c15e75-9601-40da-9342-514c145674a8",
            Analytics::class.java,
            Crashes::class.java
        )
    }

    private fun loadFromNetwork() {
        val vehicleApiHelper = VehicleApiImpl(RetrofitClient.vehicleApiService)
        GlobalScope.launch {
            val all = vehicleApiHelper.getAllVehicle()
            val byModel = vehicleApiHelper.getVehiclesByModel("model='Mustang'")
            val byMark = vehicleApiHelper.getVehiclesByMark("mark='Ford'")
            val q = byMark
        }
    }
}