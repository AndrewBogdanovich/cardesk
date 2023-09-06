package com.example.cardesk.presentation.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentOtherBinding
import com.example.cardesk.presentation.setupToolbar

class OtherFragment : Fragment() {
    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: OtherSettingsMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = true, title = "Other")
        // navigateTo(R.id.action_fragment_other_to_fragment_authorization)
        initRV()
        return binding.root
    }

    private fun initRV() {
        val items = listOf(
            OtherSettingsItem.SettingsSignIn(
                resources.getString(R.string.sign_in),
                resources.getString(
                    R.string.for_post_ads_write_messages_and_save_searches_and_bookmarks
                )
            ),
            OtherSettingsItem.SettingsHeader("Source"),
            OtherSettingsItem.SettingsItem(
                "Car valuation calculator",
                true,
                R.drawable.baseline_bar_chart_24
            ), OtherSettingsItem.SettingsItem(
                "Finance - credit, leasing",
                true,
                R.drawable.baseline_attach_money_24
            ), OtherSettingsItem.SettingsItem(
                "Installment plan",
                true,
                R.drawable.baseline_percent_24
            ),
            OtherSettingsItem.SettingsItem(
                "Vehicle check list ",
                true,
                R.drawable.baseline_check_box_24
            ),
            OtherSettingsItem.SettingsItem(
                "Modification catalog",
                true,
                R.drawable.baseline_modification_wheel_24
            ),
            OtherSettingsItem.SettingsItem(
                "VIN checker",
                true,
                R.drawable.baseline_car_info_24
            ),
            OtherSettingsItem.SettingsItem(
                "Car trader simulator",
                true,
                R.drawable.baseline_videogame_asset_24
            ),
            OtherSettingsItem.SettingsHeader("Other"),
            OtherSettingsItem.SettingsItem(
                "App theme",
                false,
                R.drawable.baseline_app_theme_4_24
            ),
            OtherSettingsItem.SettingsItem(
                "App language",
                false,
                R.drawable.baseline_language_24
            ),
            OtherSettingsItem.SettingsItem(
                "Report a problem",
                false,
                R.drawable.baseline_report_gmailerrorred_24
            ),
            OtherSettingsItem.SettingsItem(
                "Privacy policy",
                false,
                R.drawable.baseline_privacy_tip_24
            )
        )
        rvAdapter = OtherSettingsMenuAdapter()
        rvAdapter.setData(items)
        binding.otherFragmentRv.apply {
            layoutManager = LinearLayoutManager(this.context)
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                ).apply {
                    setDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.spacing,
                            null
                        )!!
                    )
                })
            adapter = rvAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}