package com.example.exchangeapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangeapp.R
import com.example.exchangeapp.data.ExchangeRate


class CurrencyRateListAdapter(private val posts: List<ExchangeRate>, private val onItemClick: (ExchangeRate) -> Unit) :
    RecyclerView.Adapter<CurrencyRateListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exchange_rate_item, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.postTextView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(posts[position])
                }
            }
        }

        fun bind(exchangeRate: ExchangeRate) {
            titleTextView.text = exchangeRate.txt
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posts = posts[position]
        holder.bind(posts)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}