package com.gcr.datosmx.ui.views.catalogue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gcr.datosmx.R
import com.gcr.datosmx.data.api.ApiHelper
import com.gcr.datosmx.data.api.RetrofitClient
import com.gcr.datosmx.ui.adapter.SchoolCycleAdapter
import com.gcr.datosmx.ui.viewmodel.MainViewModel
import com.gcr.datosmx.utils.Status
import com.gcr.datosmx.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_school_cycle.*


class SchoolCycleFragment : Fragment() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_school_cycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        setUpRecyclerView()
        setObserver()
    }

    private fun setUpRecyclerView() {
        rvCycleSchool.layoutManager = LinearLayoutManager(requireContext())
        rvCycleSchool.setHasFixedSize(true)
        rvCycleSchool.addItemDecoration( DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL))
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
        mainViewModel.getCicloEscolarInfo().observe(viewLifecycleOwner, Observer {result->
            result?.let {response->
                when(response.status){
                    Status.SUCCESS->{
                        Log.d("School", "success: ")
                        loadingCicloEscolar.visibility = View.GONE
                        rvCycleSchool.visibility = View.VISIBLE
                        rvCycleSchool.adapter = response.data?.results?.let { SchoolCycleAdapter(it) }
                    }
                }
            }
        })

        mainViewModel.getCicloEscolarInfo().observe(viewLifecycleOwner, Observer {result->
            result?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Log.d("School", "success: ")
                        loadingCicloEscolar.visibility = View.GONE
                        rvCycleSchool.visibility = View.VISIBLE
                        rvCycleSchool.adapter = resource.data?.results?.let { SchoolCycleAdapter(it) }
                    }
                    Status.ERROR -> {
                        loadingCicloEscolar.visibility = View.GONE
                        errorSchoolCycle.visibility = View.VISIBLE
                    }
                    Status.LOADING -> {
                        Log.d("School", "loading: ")
                        loadingCicloEscolar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}