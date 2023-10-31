package com.example.cardesk.presentation

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cardesk.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView

fun Fragment.setupToolbar(
    isShowing: Boolean,
    isBackButtonEnabled: Boolean? = null,
    title: String? = null
) {
    val toolbar = (requireActivity() as AppCompatActivity).supportActionBar
    if (isShowing) toolbar?.show() else toolbar?.hide()
    toolbar?.title = title
    if (isBackButtonEnabled == true) toolbar?.setDisplayHomeAsUpEnabled(true)
    else toolbar?.setDisplayHomeAsUpEnabled(false)
}

fun Fragment.setToolbarColor(color: Int) {
    activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    activity?.window?.statusBarColor = color
}

fun Fragment.navigateTo(viewId: Int, bundle: Bundle? = null) {
    this.findNavController().navigate(viewId, bundle)
}

fun Fragment.isWidthDisplay(): Boolean {
    val displayMetrics = resources.displayMetrics
    val dpWidth = displayMetrics.widthPixels / displayMetrics.density
    return dpWidth > 600
}

fun Fragment.displayBottomNavBar(isShowing: Boolean) {
    if (isWidthDisplay()) {
        val navView = activity?.findViewById<NavigationRailView>(R.id.rail_navigation_view)
        if (isShowing) {
            navView?.visibility = View.VISIBLE
        } else {
            navView?.visibility = View.GONE
        }
    } else {
        val navView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        if (isShowing) {
            navView?.visibility = View.VISIBLE
        } else {
            navView?.visibility = View.GONE
        }
    }
}