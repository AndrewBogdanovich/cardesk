package com.example.cardesk.presentation.other.model

sealed class OtherSettingsItem {
    data class SettingsSignIn(val title: String, val description: String) : OtherSettingsItem()
    data class SettingsItem(
        val name: String,
        val isArrowEnabled: Boolean,
        val imageId: Int? = null
    ) : OtherSettingsItem()

    data class SettingsHeader(val title: String) : OtherSettingsItem()
}