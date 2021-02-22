package com.gcr.datosmx.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gcr.datosmx.R
import com.gcr.datosmx.data.models.responses.school.CicloEscolar
import kotlinx.android.synthetic.main.item_cycles_school.view.*

class SchoolCycleAdapter(val list: List<CicloEscolar>) :
    RecyclerView.Adapter<SchoolCycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cycles_school, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CicloEscolar) {
            itemView.tvDesglose.text = item.desglose
            itemView.tvCycleSchool.text = item.cicloEscolar
            itemView.tvNumberSchool.text = item.numEscuela
        }
    }
}