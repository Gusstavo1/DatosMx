package com.gcr.datosmx.ui.adapter

import DashBoard
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gcr.datosmx.R
import kotlinx.android.synthetic.main.item_button.view.*

class DashBoardAdapter(val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<DashBoardAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return setData().size
    }

    override fun onBindViewHolder(holder: DashBoardAdapter.Holder, position: Int) {
        val item = setData()[position]
        holder.bind(item, position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dashBoard: DashBoard, position: Int) {
            itemView.ivIcon.setImageResource(dashBoard.image)
            itemView.tvDescription.text = dashBoard.description
            itemView.setOnClickListener {
                itemClickListener.itemClickListener(position)
            }
        }
    }

    private fun setData(): List<DashBoard> {
        val list = listOf(
            DashBoard(R.drawable.catalogue, "Catálogo de datos"),
            DashBoard(R.drawable.brochure, "Zonas Turísticas"),
            DashBoard(R.drawable.browser, "Portal datos abiertos"),
            DashBoard(R.drawable.phone, "Noticias")
        )
        return list
    }

    interface ItemClickListener {
        fun itemClickListener(position: Int)
    }
}