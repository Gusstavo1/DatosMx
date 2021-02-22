package com.gcr.datosmx.ui.views.catalogue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcr.datosmx.R
import com.gcr.datosmx.ui.adapter.CatalogueAdapter
import kotlinx.android.synthetic.main.fragment_catalogue.*


class CatalogueFragment : Fragment(), CatalogueAdapter.ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_catalogue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val adapter = CatalogueAdapter(this)
        rvCatalogue.layoutManager = LinearLayoutManager(requireContext())
        rvCatalogue.setHasFixedSize(true)
        rvCatalogue.adapter = adapter
        rvCatalogue.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun itemClickListener(position: Int) {
        when (position) {
            /*0->{findNavController().navigate(R.id.action_catalogueFragment_to_schoolCycleFragment)}
            1->{findNavController().navigate(R.id.action_catalogueFragment_to_unemploymentFragment)}
            2->{findNavController().navigate(R.id.action_catalogueFragment_to_secundarySchoolFragment)}
            3->{findNavController().navigate(R.id.action_catalogueFragment_to_internetHomeFragment)}
            4->{findNavController().navigate(R.id.action_catalogueFragment_to_nativeAmericanLanguageFragment)}
            5->{findNavController().navigate(R.id.action_catalogueFragment_to_peopleFragment)}
            6->{findNavController().navigate(R.id.action_catalogueFragment_to_gasPriceFragment)}
            7->{findNavController().navigate(R.id.action_catalogueFragment_to_seedsFragment)}*/
            0 -> {
                findNavController().navigate(R.id.action_catalogueFragment_to_schoolCycleFragment)
            }
            1 -> {
                findNavController().navigate(R.id.action_catalogueFragment_to_nativeAmericanLanguageFragment)
            }
            2 -> {
                findNavController().navigate(R.id.action_catalogueFragment_to_gasPriceFragment)
            }
        }
    }

}