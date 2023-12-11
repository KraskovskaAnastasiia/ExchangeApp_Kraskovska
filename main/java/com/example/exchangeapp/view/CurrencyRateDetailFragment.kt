package com.example.exchangeapp.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.exchangeapp.R
import com.example.exchangeapp.data.ExchangeRate
import com.example.exchangeapp.viewmodel.CurrencyRateDetailViewModel


class CurrencyRateDetailFragment : Fragment(R.layout.exchange_rate_detail_fragment) {

    private lateinit var viewModel: CurrencyRateDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exchangeRate: ExchangeRate = CurrencyRateDetailFragmentArgs.fromBundle(requireArguments()).exchangeRate
        //val exchangeRate: ExchangeRate = PostDetailFragmentArgs.fromBundle(requireArguments()).post
        viewModel = ViewModelProvider(this)[CurrencyRateDetailViewModel::class.java]
        observeViewModel()
        viewModel.getExchangeRate(exchangeRate.cc)
    }

    private fun observeViewModel() {
        viewModel.post.observe(viewLifecycleOwner) { post ->
            updateUI(post)
        }
    }

    private fun updateUI(exchangeRate: ExchangeRate) {
        val idTextView: TextView = view?.findViewById(R.id.txt) ?: return
        val userIdTextView: TextView = view?.findViewById(R.id.rate) ?: return
        val titleTextView: TextView = view?.findViewById(R.id.cc) ?: return
        val bodyTextView: TextView = view?.findViewById(R.id.exchangedate) ?: return

        idTextView.text = exchangeRate.txt
        userIdTextView.text = exchangeRate.rate.toString()
        titleTextView.text = exchangeRate.cc
        bodyTextView.text = exchangeRate.exchangeDate
    }
}