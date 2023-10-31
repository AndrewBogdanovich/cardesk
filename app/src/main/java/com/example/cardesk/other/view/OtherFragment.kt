package com.example.cardesk.other.view

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
import com.example.cardesk.navigateTo
import com.example.cardesk.other.adapter.OtherSettingsMenuAdapter
import com.example.cardesk.other.model.OtherSettingsItem
import com.example.cardesk.setupToolbar

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
        initRecyclerView()
        rvAdapter.setOnClickListener(object : OtherSettingsMenuAdapter.OnClickListener {
            override fun onClick(position: Int, model: OtherSettingsItem) {
                setupRecyclerItemsNavigation(model)
            }
        })
        return binding.root
    }

    private fun setupRecyclerItemsNavigation(model: OtherSettingsItem) {
        when (model) {
            is OtherSettingsItem.SettingsSignIn -> {
                navigateTo(R.id.action_fragment_other_to_fragment_authorization)
            }

            is OtherSettingsItem.SettingsItem -> {
                when (model.name) {
                    getString(R.string.vin_checker) -> navigateTo(R.id.action_fragment_other_to_fragment_vin_checker)
                    getString(R.string.car_valuation_calculator) -> navigateTo(R.id.action_fragment_other_to_fragment_car_valuation_calculator)
                    getString(R.string.finance_credit_leasing) -> navigateTo(R.id.action_fragment_other_to_fragment_finance)
                    getString(R.string.installment_plan) -> navigateTo(R.id.action_fragment_other_to_fragment_installment_plan)
                    getString(R.string.vehicle_check_list) -> navigateTo(R.id.action_fragment_other_to_fragment_vehicle_checklist)
                    getString(R.string.modification_catalog) -> navigateTo(R.id.action_fragment_other_to_fragment_modification_catalog)
                    getString(R.string.car_trader_simulator) -> navigateTo(R.id.action_fragment_other_to_fragment_car_trade_simulator)

                    getString(R.string.app_language) -> navigateTo(R.id.action_fragment_other_to_appLanguageFragment)
                    getString(R.string.app_theme) -> navigateTo(R.id.action_fragment_other_to_appThemeFragment)
                    getString(R.string.privacy_policy) -> navigateTo(R.id.action_fragment_other_to_privacyPolicyFragment)
                    getString(R.string.report_a_problem) -> navigateTo(R.id.action_fragment_other_to_reportProblemFragment)
                }
            }

            else -> return
        }
    }

    private fun initRecyclerView() {
        rvAdapter = OtherSettingsMenuAdapter()
        val data = createRecyclerDataObject()
        rvAdapter.setData(data)
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

    private fun createRecyclerDataObject(): List<OtherSettingsItem> {
        //TODO refactoring creating object
        return listOf(
            OtherSettingsItem.SettingsSignIn(
                resources.getString(R.string.sign_in),
                resources.getString(
                    R.string.for_post_ads_write_messages_and_save_searches_and_bookmarks
                )
            ),
            OtherSettingsItem.SettingsHeader(getString(R.string.source)),
            OtherSettingsItem.SettingsItem(
                getString(R.string.car_valuation_calculator),
                true,
                R.drawable.baseline_bar_chart_24
            ), OtherSettingsItem.SettingsItem(
                getString(R.string.finance_credit_leasing),
                true,
                R.drawable.baseline_attach_money_24
            ), OtherSettingsItem.SettingsItem(
                getString(R.string.installment_plan),
                true,
                R.drawable.baseline_percent_24
            ),
            OtherSettingsItem.SettingsItem(
                getString(R.string.vehicle_check_list),
                true,
                R.drawable.baseline_check_box_24
            ),
            OtherSettingsItem.SettingsItem(
                getString(R.string.modification_catalog),
                true,
                R.drawable.baseline_modification_wheel_24
            ),
            OtherSettingsItem.SettingsItem(
                getString(R.string.vin_checker),
                true,
                R.drawable.baseline_car_info_24
            ),
            OtherSettingsItem.SettingsItem(
                getString(R.string.car_trader_simulator),
                true,
                R.drawable.baseline_videogame_asset_24
            ),
            OtherSettingsItem.SettingsHeader(getString(R.string.other)),
            OtherSettingsItem.SettingsItem(
                getString(R.string.app_theme),
                false,
                R.drawable.baseline_app_theme_4_24
            ),
            OtherSettingsItem.SettingsItem(
                getString(R.string.app_language),
                false,
                R.drawable.baseline_language_24
            ),
            OtherSettingsItem.SettingsItem(
                getString(R.string.report_a_problem),
                false,
                R.drawable.baseline_report_gmailerrorred_24
            ),
            OtherSettingsItem.SettingsItem(
                getString(R.string.privacy_policy),
                false,
                R.drawable.baseline_privacy_tip_24
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}