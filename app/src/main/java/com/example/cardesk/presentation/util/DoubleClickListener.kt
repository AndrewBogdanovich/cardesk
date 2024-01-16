package com.example.cardesk.presentation.util

import android.view.View

abstract class DoubleClickListener : View.OnClickListener {
    private var lastTimeClick: Long = 0
    override fun onClick(v: View) {
        val clickTime = System.currentTimeMillis()
        if (clickTime - lastTimeClick < 300){
            onDoubleCLick(v)
            lastTimeClick = 0
        }
        lastTimeClick = clickTime
    }

    abstract fun onDoubleCLick(v: View)
}