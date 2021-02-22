package com.gcr.datosmx.ui.views.catalogue.gasoline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gcr.datosmx.R
import com.gcr.datosmx.utils.ResizeMarker
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.fragment_gas_station.*

class GasStationFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private val args: GasStationFragmentArgs by navArgs()
    private val TAG = "GStation"
    private lateinit var map: GoogleMap
    private lateinit var buttonSheetFragment: ButtonSheetFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapGasStation.onCreate(savedInstanceState)
        mapGasStation.onResume()
        mapGasStation.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gas_station, container, false)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val style = MapStyleOptions.loadRawResourceStyle(this.context, R.raw.map_style)
        map = googleMap
        map.setMapStyle(style)
        buttonSheetFragment =
            ButtonSheetFragment()
        args.gasPrice?.calle?.let { buttonSheetFragment.setAddress(it) }
        args.gasPrice?.razonsocial?.let { buttonSheetFragment.setCompany(it) }

        map.setOnMarkerClickListener(this)
        createMarker()
    }


    private fun createMarker() {
        val lat: Double = args.gasPrice!!.latitude.toDouble()
        val lng: Double = args.gasPrice!!.longitude.toDouble()
        val coordinates = LatLng(lat, lng)
        val maker = MarkerOptions()
            .position(coordinates)
            .title(args.gasPrice!!.razonsocial)
            .icon(
                BitmapDescriptorFactory.fromBitmap(
                    ResizeMarker.resizeBitmap(
                        requireContext(),
                        "gas_marker",
                        160,
                        170
                    )
                )
            )
        map.addMarker(maker)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 12f))
    }

    override fun onMarkerClick(marker: Marker?): Boolean {

        activity?.supportFragmentManager?.let {
            buttonSheetFragment.show(it, "buttonSheet")
        }
        return true
    }
}