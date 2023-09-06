package com.example.cardesk.presentation.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cardesk.R

class OtherSettingsMenuAdapter :
    RecyclerView.Adapter<OtherSettingsViewHolder>() {

    private val adapterData = mutableListOf<OtherSettingsItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherSettingsViewHolder {
        val layout = when (viewType) {
            HEADER_TYPE -> R.layout.other_menu_header_item
            ITEM_TYPE -> R.layout.other_menu_item
            SIGN_IN_TYPE -> R.layout.other_menu_signin_item
            else -> throw IllegalArgumentException("Invalid type")
        }

        val view = LayoutInflater
            .from(parent.context)
            .inflate(layout, parent, false)

        return OtherSettingsViewHolder(view)
    }

    override fun getItemCount(): Int = adapterData.size

    override fun onBindViewHolder(holder: OtherSettingsViewHolder, position: Int) {
        holder.bind(adapterData[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (adapterData[position]) {
            is OtherSettingsItem.SettingsHeader -> HEADER_TYPE
            is OtherSettingsItem.SettingsItem -> ITEM_TYPE
            is OtherSettingsItem.SettingsSignIn -> SIGN_IN_TYPE
        }
    }

    fun setData(data: List<OtherSettingsItem>) {
        adapterData.apply {
            clear()
            addAll(data)
        }
    }

    companion object {
        private const val HEADER_TYPE = 0
        private const val ITEM_TYPE = 1
        private const val SIGN_IN_TYPE = 2

    }
}

class OtherSettingsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private fun bindItem(items: OtherSettingsItem.SettingsItem) {
        val rowText = view.findViewById<TextView>(R.id.row_text)
        rowText.text = items.name

        val rowArrowIcon = view.findViewById<ImageView>(R.id.row_arrow_icon)
        rowArrowIcon.setImageResource(R.drawable.baseline_arrow_forward_ios_24)
        if (items.isArrowEnabled) rowArrowIcon.visibility =
            View.VISIBLE else rowArrowIcon.visibility = View.GONE

        if (items.imageId !=null){
            val rowIcon = view.findViewById<ImageView>(R.id.row_icon)
            rowIcon.setImageResource(items.imageId)
        }
    }

    private fun bindHeader(header: OtherSettingsItem.SettingsHeader) {
        val headerText = view.findViewById<TextView>(R.id.header_text)
        headerText.text = header.title
    }

    private fun bindSignIn(signIn: OtherSettingsItem.SettingsSignIn){
        val title = view.findViewById<TextView>(R.id.other_menu_sign_in_title)
        val description = view.findViewById<TextView>(R.id.other_menu_sign_in_description)

        title.text = signIn.title
        description.text = signIn.description
    }

    fun bind(items: OtherSettingsItem) {
        when (items) {
            is OtherSettingsItem.SettingsItem -> bindItem(items)
            is OtherSettingsItem.SettingsHeader -> bindHeader(items)
            is OtherSettingsItem.SettingsSignIn -> bindSignIn(items)
        }
    }
}
