package com.example.exchangeapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangeapp.R
import com.example.exchangeapp.data.ExchangeRate
import com.example.exchangeapp.view.adapter.CurrencyRateListAdapter
import com.example.exchangeapp.viewmodel.CurrencyRateListViewModel


class CurrencyRateListFragment : Fragment(R.layout.exchange_rate_list_fragment) {
    private lateinit var viewModel: CurrencyRateListViewModel
    private lateinit var currencyRateListAdapter: CurrencyRateListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this)[CurrencyRateListViewModel::class.java]
        viewModel.getCurrencyRateList().observe(viewLifecycleOwner) { posts -> currencyRateListAdapter = CurrencyRateListAdapter(posts) { selectedPost -> navigateToExchangeRateDetail(selectedPost) }
            recyclerView.adapter = currencyRateListAdapter
        }
    }

    private fun navigateToExchangeRateDetail(exchangeRate: ExchangeRate) {
        val action = CurrencyRateListFragmentDirections.actionPostListFragmentToPostDetailFragment(exchangeRate)
        findNavController().navigate(action)
    }
}