package com.gcr.datosmx.ui.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gcr.datosmx.R
import com.gcr.datosmx.data.api.ApiHelper
import com.gcr.datosmx.data.api.RetrofitClient
import com.gcr.datosmx.ui.adapter.DashBoardAdapter
import com.gcr.datosmx.ui.viewmodel.MainViewModel
import com.gcr.datosmx.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), DashBoardAdapter.ItemClickListener {

    private lateinit var mainViewModel: MainViewModel
    private val TAG: String = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        //setUpGasPriceObserver()
        setUpRecyclerView()
        setUpGreetings()
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProvider(
            this, ViewModelFactory(
                ApiHelper(RetrofitClient.apiService)
            )
        ).get(MainViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    private fun setUpGreetings() {
        mainViewModel.getGreeting()
        mainViewModel.hour.observe(viewLifecycleOwner, Observer { hour ->

            when {
                hour < 12 -> {
                    tvGreetings.text = "Buenos días"
                }
                hour < 19 -> {
                    tvGreetings.text = "Buenas tardes"
                }
                else -> tvGreetings.text = "Buenas noches"
            }
        })
    }

    @SuppressLint("WrongConstant")
    private fun setUpRecyclerView() {
        val mAdapter = DashBoardAdapter(this)
        val gridLayout = GridLayoutManager(requireContext(), 2, LinearLayout.VERTICAL, false)
        rvDashboard.layoutManager = gridLayout
        rvDashboard.setHasFixedSize(true)
        rvDashboard.adapter = mAdapter
    }


    override fun itemClickListener(position: Int) {
        when (position) {
            0 -> {
                findNavController().navigate(R.id.action_mainFragment_to_catalogueFragment)
            }
            1 -> {
                findNavController().navigate(R.id.action_mainFragment_to_archaeologicalZonesFragment)
            }
            2 -> {
                findNavController().navigate(R.id.action_mainFragment_to_webViewFragment)
            }
            3 -> {
                findNavController().navigate(R.id.action_mainFragment_to_newsFragment)
            }

        }
    }
}