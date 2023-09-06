package com.example.cardesk.presentation

import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.setupToolbar(isShowing: Boolean, isBackButtonEnabled: Boolean? = null, title: String? = null) {
    val toolbar = (requireActivity() as AppCompatActivity).supportActionBar
    if (isShowing) toolbar?.show() else toolbar?.hide()
    toolbar?.title = title
    if (isBackButtonEnabled == true) toolbar?.setDisplayHomeAsUpEnabled(true)
    else toolbar?.setDisplayHomeAsUpEnabled(false)
}

fun Fragment.setToolbarColor(color: Int){
    activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    activity?.window?.statusBarColor = color
}

fun Fragment.navigateTo(viewId: Int){
    this.findNavController().navigate(viewId)
}