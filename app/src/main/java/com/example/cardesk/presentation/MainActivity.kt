package com.example.cardesk.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.cardesk.R
import com.example.cardesk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setSupportActionBar(binding.appToolbar)
        setupNavigationController()
    }

    private fun setupNavigationController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val displayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density

        if (dpWidth > 600) {
            binding.railNavigationView.visibility = View.VISIBLE
            binding.bottomNavigationView.visibility = View.GONE
            binding.railNavigationView.apply {
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
        } else {
            binding.railNavigationView.visibility = View.GONE
            binding.bottomNavigationView.visibility = View.VISIBLE
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
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}