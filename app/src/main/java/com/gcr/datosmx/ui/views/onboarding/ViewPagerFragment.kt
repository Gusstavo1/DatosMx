package com.gcr.datosmx.ui.views.onboarding

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.gcr.datosmx.R
import com.gcr.datosmx.ui.adapter.ViewPagerAdapter
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.fragment_view_pager.*
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listFragments = arrayListOf(
            Screen1Fragment(),
            Screen2Fragment(),
            Screen3Fragment()
        )

        val adapter = ViewPagerAdapter(
            listFragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewPagerMx.adapter = adapter

        indicator.apply {
            setSliderColor(Color.rgb(133,193,233),Color.rgb(7,134,220))
            setSliderWidth(resources.getDimension(R.dimen.sliderWidth))
            setSliderHeight(resources.getDimension(R.dimen.sliderEight))
            setSlideMode(IndicatorSlideMode.WORM)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setupWithViewPager(view.viewPagerMx)
        }

        viewPagerMx.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                indicator.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator.onPageSelected(position)
            }
        })

    }
}