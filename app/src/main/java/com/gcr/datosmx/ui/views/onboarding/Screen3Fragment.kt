package com.gcr.datosmx.ui.views.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gcr.datosmx.R
import kotlinx.android.synthetic.main.fragment_screen3.*
import kotlinx.android.synthetic.main.fragment_view_pager.*


class Screen3Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_screen3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPagerMx?.currentItem = 3
        btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_mainFragment)
            onBoardingFinish()
        }
    }

    private fun onBoardingFinish(){
        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("finished",true)
        editor.apply()
    }
}