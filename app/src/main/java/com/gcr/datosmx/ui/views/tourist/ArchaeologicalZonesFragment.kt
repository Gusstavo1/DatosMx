package com.gcr.datosmx.ui.views.tourist

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gcr.datosmx.R
import com.gcr.datosmx.data.models.Place
import com.gcr.datosmx.data.repositories.MapRepository
import com.gcr.datosmx.ui.viewmodel.MapViewModel
import com.gcr.datosmx.utils.ResizeMarker
import com.gcr.datosmx.utils.ViewModelMapFactory
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.fragment_archaeological_zones.*
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ArchaeologicalZonesFragment : Fragment(), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {

    lateinit var googleMap: GoogleMap
    lateinit var mapViewModel: MapViewModel
    lateinit var listPlaces: List<Place>
    private val TAG = "Turismo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pyramidMap.onCreate(savedInstanceState)
        pyramidMap.onResume()
        pyramidMap.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_archaeological_zones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMapViewModel()
        setUpCoordinatesObserver()

        btnPyramids.setOnClickListener {
            mapViewModel.setPyramides()
            createMarkers(listPlaces, googleMap, "piramid")
            btnChecked(btnPyramids)
        }

        btnBeaches.setOnClickListener {
            mapViewModel.setBeaches()
            createMarkers(listPlaces, googleMap, "parasol")
            btnChecked(btnBeaches)
        }

        btnMuseums.setOnClickListener {
            mapViewModel.setMuseums()
            createMarkers(listPlaces, googleMap, "museo")
            btnChecked(btnMuseums)
        }

        btnAllPlaces.setOnClickListener {
        }
    }

    override fun onMapReady(map: GoogleMap) {

        val style = MapStyleOptions
            .loadRawResourceStyle(
                this.context,
                R.raw.map_style
            )
        val mexico = LatLng(24.09803, -102.91085)
        val markers = listPlaces

        googleMap = map
        googleMap.setOnMarkerClickListener(this)
        googleMap.setMapStyle(style)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mexico, 5f))

        btnChecked(btnPyramids)
        createMarkers(
            markers,
            googleMap,
            "piramid"
        )
    }

    private fun setUpMapViewModel() {
        mapViewModel = ViewModelProvider(
            this, ViewModelMapFactory(
                MapRepository()
            )
        ).get(MapViewModel::class.java)
    }

    private fun setUpCoordinatesObserver() {
        mapViewModel.coordinates.observe(viewLifecycleOwner, Observer { places ->
            listPlaces = places
        })
    }

    private fun createMarkers(markers: List<Place>, googleMap: GoogleMap, drawableName: String) {
        googleMap.clear()
        googleMap.apply {
            markers.forEach { place ->
                val coordinates = LatLng(place.lat, place.lng)
                addMarker(
                    MarkerOptions()
                        .position(coordinates)
                        .title(place.name)
                        .icon(
                            BitmapDescriptorFactory.fromBitmap(
                                ResizeMarker.resizeBitmap(
                                    requireContext(),
                                    drawableName,
                                    180,
                                    190
                                )
                            )
                        )
                )
            }
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {

        val element = listPlaces.filter { place ->
            marker.title == place.name
        }
        createDialog(element[0].name, element[0].desc, element[0].url)
        return false
    }

    private fun createDialog(title: String, desc: String, url: String) {
        val view = View.inflate(requireContext(), R.layout.fragment_details, null)
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(view)
        val dialog = alertDialogBuilder.create()
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        view.tvTiTle.text = title
        view.tvDescription.text = desc

        Glide.with(this)
            .load(url)
            .error(R.drawable.preview)
            //.placeholder(R.drawable.progress_animation)
            .centerCrop()
            .apply(RequestOptions().override(600, 400))
            .into(view.ivPlace)

        view.btnClose.setOnClickListener {
            dialog.dismiss()
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun btnChecked(btn: Button) {
        GlobalScope.launch {
            when (btn) {
                btnPyramids -> {
                    btnPyramids.setBackgroundColor(Color.rgb(7, 134, 220))
                    btnBeaches.setBackgroundColor(Color.rgb(176, 225, 251))
                    btnMuseums.setBackgroundColor(Color.rgb(176, 225, 251))
                }
                btnMuseums -> {
                    btnMuseums.setBackgroundColor(Color.rgb(7, 134, 220))
                    btnPyramids.setBackgroundColor(Color.rgb(176, 225, 251))
                    btnBeaches.setBackgroundColor(Color.rgb(176, 225, 251))
                }
                btnBeaches -> {
                    btnBeaches.setBackgroundColor(Color.rgb(7, 134, 220))
                    btnPyramids.setBackgroundColor(Color.rgb(176, 225, 251))
                    btnMuseums.setBackgroundColor(Color.rgb(176, 225, 251))
                }
            }
        }
    }
}

//para obtener la posición de marcadores
/*https://stackoverflow.com/questions/42469352/android-how-to-get-the-position-of-marker-on-google-map-v2-and-match-it-to-the*/
//Agregar un botonsheet cuando presionas un marcador
//https://stackoverflow.com/questions/66027101/simple-windows-on-the-bottom-of-googlemap-in-androidstudio-in-kotlin