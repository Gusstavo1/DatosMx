package com.gcr.datosmx.ui.views.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gcr.datosmx.R
import kotlinx.android.synthetic.main.fragment_view_pager.*


class Screen1Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_screen1, container, false)
        viewPagerMx?.currentItem = 1
        return view

    }
}