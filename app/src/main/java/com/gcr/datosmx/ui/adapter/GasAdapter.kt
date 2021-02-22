package com.gcr.datosmx.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gcr.datosmx.R
import com.gcr.datosmx.data.models.responses.gas.GasPrice
import kotlinx.android.synthetic.main.item_gas_price.view.*

class GasAdapter(val list: List<GasPrice>, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<GasAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_gas_price, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val element = list[position]
        holder.bind(element)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: GasPrice) {
            itemView.tvLastUpdate.text = item.date_insert
            itemView.tvMagnaPrice.text = item.regular
            itemView.tvPremiumPrice.text = item.premium
            itemView.setOnClickListener {
                itemClickListener.itemClickListener(item)
            }
        }
    }

    interface ItemClickListener {
        fun itemClickListener(item: GasPrice)
    }
}