package com.gcr.datosmx.ui.adapter

import Catalogue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gcr.datosmx.R
import kotlinx.android.synthetic.main.item_catalogue.view.*

class CatalogueAdapter(val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<CatalogueAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueAdapter.Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_catalogue, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return setData().size
    }

    override fun onBindViewHolder(holder: CatalogueAdapter.Holder, position: Int) {
        val item = setData()[position]
        holder.itemView.ivCatalogue.setImageResource(setData()[position].icon)
        holder.bind(item, position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Catalogue, position: Int) {
            itemView.tvDescription.text = item.description
            itemView.setOnClickListener {
                itemClickListener.itemClickListener(position)
            }
        }
    }

    interface ItemClickListener {
        fun itemClickListener(position: Int)
    }

    /*private fun setData(): List<Catalogue> {
        val list = listOf(
            Catalogue(R.drawable.school, 0, "Ciclos escolares"),
            Catalogue(R.drawable.empleo1, 0, "Desempleo"),
            Catalogue(R.drawable.school, 0, "Educación secundaria"),
            Catalogue(R.drawable.internet, 0, "Hogares con internet"),
            Catalogue(R.drawable.plumas, 0, "Lengua indigena"),
            Catalogue(R.drawable.youth, 0, "Poblaciones pequeñas"),
            Catalogue(R.drawable.gasoline, 0, "Precio de gasolina"),
            Catalogue(R.drawable.corn, 0, "Producción de granos"))
        return list
    }*/

    private fun setData(): List<Catalogue> {
        val list = listOf(
            Catalogue(R.drawable.school,  "Ciclos escolares"),
            Catalogue(R.drawable.plumas,  "Lengua indigena"),
            Catalogue(R.drawable.gasoline,  "Precio de gasolina")
        )
        return list
    }
}