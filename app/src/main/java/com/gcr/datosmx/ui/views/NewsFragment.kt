package com.gcr.datosmx.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gcr.datosmx.R
import com.gcr.datosmx.ui.viewmodel.NewsViewModel


class NewsFragment : Fragment() {

    //lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setUpViewModel()
    }

    /*private fun setUpViewModel() {
        newsViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelper(RetrofitClient.newService)
            )
        ).get(NewsViewModel::class.java)
    }*/
}