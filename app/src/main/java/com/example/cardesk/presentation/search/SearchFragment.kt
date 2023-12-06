package com.example.cardesk.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardesk.R
import com.example.cardesk.databinding.FragmentSearchBinding
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.presentation.extension.navigateTo
import com.example.cardesk.presentation.extension.setupToolbar
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private lateinit var rvAdapter: AdsAdapter
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels { SearchViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        setupToolbar(isShowing = false)
        lifecycleScope.launch {
            viewModel.ads.collect{
                setupRecyclerView(it)
            }
        }
        return binding.root
    }

    private fun setupRecyclerView(data: List<AdvertisementModel>) {
        rvAdapter = AdsAdapter()
        rvAdapter.setData(data)
        binding.searchRv.layoutManager = LinearLayoutManager(this.context)
        binding.searchRv.addItemDecoration(DividerItemDecoration(
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
        binding.searchRv.adapter = rvAdapter
        rvAdapter.setOnClickListener(object : AdsAdapter.OnClickListener {
            override fun onClick(
                position: Int,
                model: AdvertisementModel
            ) {
                itemSelected(model)
            }
        })
    }

    private fun itemSelected(model: AdvertisementModel) {
        val bundle = Bundle()
        bundle.putString("adsObjectId", model.id)
        navigateTo(R.id.action_fragment_search_to_advertisementDetailFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

