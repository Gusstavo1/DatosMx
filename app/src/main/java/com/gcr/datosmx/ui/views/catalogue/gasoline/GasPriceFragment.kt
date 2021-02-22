package com.gcr.datosmx.ui.views.catalogue.gasoline

import com.gcr.datosmx.ui.adapter.GasAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gcr.datosmx.R
import com.gcr.datosmx.data.api.ApiHelper
import com.gcr.datosmx.data.api.RetrofitClient
import com.gcr.datosmx.data.models.responses.gas.GasPrice
import com.gcr.datosmx.ui.viewmodel.MainViewModel
import com.gcr.datosmx.utils.Status
import com.gcr.datosmx.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_gas_price.*


class GasPriceFragment : Fragment(), GasAdapter.ItemClickListener {

    lateinit var mainViewModel: MainViewModel
    private val TAG = "Gas"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_gas_price, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        setUpViewModel()
        sepUtRecycler()
        setObserver()
    }

    private fun setUpViewModel() {
        mainViewModel =
            ViewModelProvider(
                this, ViewModelFactory(
                    ApiHelper(RetrofitClient.apiService)
                )
            ).get(
                MainViewModel::class.java
            )
    }

    private fun setObserver() {
        mainViewModel.getGasPrice().observe(viewLifecycleOwner, Observer {result->
            result?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Log.d(TAG, "Success: ")
                        gasLoading.visibility = View.GONE
                        rvGasPrice.visibility = View.VISIBLE
                        rvGasPrice.adapter = resource.data?.results?.let { GasAdapter(it,this) }
                    }
                    Status.ERROR -> {
                        gasLoading.visibility = View.GONE
                        errorGasPrice.visibility = View.VISIBLE
                        Log.d(TAG, "Algo ocurrio ")
                    }
                    Status.LOADING -> {
                        gasLoading.visibility = View.VISIBLE
                        Log.d(TAG, "Cargando ")
                    }
                }
            }
        })
    }

    private fun sepUtRecycler(){
        rvGasPrice.layoutManager = LinearLayoutManager(requireContext())
        rvGasPrice.setHasFixedSize(true)
        rvGasPrice.addItemDecoration( DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL)
        )
    }

    override fun itemClickListener(item: GasPrice) {
        val action =
            GasPriceFragmentDirections.actionGasPriceFragmentToGasStationFragment(
                item
            )
        findNavController().navigate(action)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }
}