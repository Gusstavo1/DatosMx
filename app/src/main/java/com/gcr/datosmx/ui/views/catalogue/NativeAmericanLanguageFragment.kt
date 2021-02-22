package com.gcr.datosmx.ui.views.catalogue

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gcr.datosmx.R
import com.gcr.datosmx.data.localdata.DidYouKnow
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_native_american_language.*
import kotlin.random.Random


class NativeAmericanLanguageFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mapZone: GoogleMap
    private var showMap = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        languageMap.onCreate(savedInstanceState)
        languageMap.onResume()
        languageMap.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_native_american_language, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnShowMap.setOnClickListener {
            if (!showMap){
                languageMap.visibility = View.VISIBLE
                //languages.visibility = View.VISIBLE
                showMap = true
                btnShowMap.text = "Ocultar mapa"
            }else{
                languageMap.visibility = View.GONE
                //languages.visibility = View.GONE
                showMap = false
                btnShowMap.text = "Ver mapa"
            }
        }
        setTextViews()
    }

    private fun setTextViews(){

        val didYouKnow = DidYouKnow()
        val randomPosition = Random.nextInt((didYouKnow.dataInfo().size-1)+1)//3
        didYouKnow.dataInfo()
        tvMainTitle.text = didYouKnow.dataInfo()[randomPosition].title
        tvExplain.text = didYouKnow.dataInfo()[randomPosition].description
    }
    override fun onMapReady(map: GoogleMap) {
        mapZone = map
        val style = MapStyleOptions.loadRawResourceStyle(this.context, R.raw.map_style)
        mapZone.setMapStyle(style)

        val mexico = LatLng(24.09803, -102.91085)
        mapZone.apply {
            addMarker(
                MarkerOptions()
                    .position(mexico)
                    .title("México")
            )
        }

        mapZone.moveCamera(CameraUpdateFactory.newLatLngZoom(mexico, 4f))
        // Maya
        val merida = LatLng(20.965902918368993, -89.59791191795729)
        val valladolid = LatLng(20.732471069412334, -88.20842935969276)
        val cancun = LatLng(21.167438515160537, -86.85129640932453)
        val quintanaRoo = LatLng(19.28011959737273, -87.5017052776679)
        val campeche = LatLng(19.204113854957658, -90.26302491290005)
        val dzilbachen = LatLng(19.560073462498224, -89.66496533512694)
        val chiapas = LatLng(17.04683970825905, -93.01644660630397)

        // Oto mangue Oaxaca
        val oaxaca = LatLng(16.78980138194117, -96.65883039437887)
        val ometepecGro = LatLng(16.74322730801531, -98.42399901089776)
        val toluca = LatLng(19.296716045706148, -99.6585875552649)
        val atlacomulco = LatLng(19.80788424500181, -99.83436879378147)
        val polotitlan = LatLng(20.230499207909276, -99.82572295011977)
        val hidalgo = LatLng(20.535699703571236, -99.19773797464819)

        // nahua
        val morelos = LatLng(18.813743930604414, -98.9909470650237)
        val iguala = LatLng(18.372504499331736, -99.54531064180252)
        val puebla = LatLng(19.093574438963753, -98.45320694722197)
        val chautlaGro = LatLng(17.981165540050654, -98.8449381702013)
        val michoacan = LatLng(18.361514617453967, -103.06368801876306)
        val triangulo = LatLng(22.35471489480779, -104.27113049757796)
        val chihuahuaSur = LatLng(26.41237519413372, -106.87409816561161)
        val chihuahuaOeste = LatLng(27.74269952316302, -108.19245745448562)
        val navojoa = LatLng(27.079511349429094, -109.44489877173868)
        val mochis = LatLng(25.840278095685438, -108.93952771100363)
        val papantla = LatLng(20.473416450986782, -97.31286656746953)

        mapZone.addCircle(
            CircleOptions()
                .center(merida)
                .radius(100000.0)
                .strokeColor(Color.RED)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,150,50,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(valladolid)
                .radius(99000.0)
                .strokeColor(Color.RED)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,150,50,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(cancun)
                .radius(50000.0)
                .strokeColor(Color.RED)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,150,50,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(quintanaRoo)
                .radius(100000.0)
                .strokeColor(Color.RED)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,150,50,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(campeche)
                .radius(90000.0)
                .strokeColor(Color.RED)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,150,50,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(dzilbachen)
                .radius(80000.0)
                .strokeColor(Color.RED)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,150,50,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(chiapas)
                .radius(100000.0)
                .strokeColor(Color.RED)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,150,50,50))
        )

        // Otomi

        mapZone.addCircle(
            CircleOptions()
                .center(oaxaca)
                .radius(200000.0)
                .strokeColor(Color.BLUE)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,50,150))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(ometepecGro)
                .radius(40000.0)
                .strokeColor(Color.BLUE)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,50,150))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(toluca)
                .radius(80000.0)
                .strokeColor(Color.BLUE)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,50,150))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(atlacomulco)
                .radius(60000.0)
                .strokeColor(Color.BLUE)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,50,150))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(polotitlan)
                .radius(60000.0)
                .strokeColor(Color.BLUE)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,50,150))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(hidalgo)
                .radius(100000.0)
                .strokeColor(Color.BLUE)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,50,150))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(morelos)
                .radius(20000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(iguala)
                .radius(40000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(puebla)
                .radius(30000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(chautlaGro)
                .radius(30000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(michoacan)
                .radius(30000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(triangulo)
                .radius(70000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(chihuahuaSur)
                .radius(80000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(chihuahuaOeste)
                .radius(80000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(navojoa)
                .radius(60000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(mochis)
                .radius(60000.0)
                .strokeColor(Color.GREEN)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,50,150,50))
        )

        mapZone.addCircle(
            CircleOptions()
                .center(papantla)
                .radius(80000.0)
                .strokeColor(Color.MAGENTA)
                .strokeWidth(1f)
                .fillColor(Color.argb(70,207,52,118))
        )
    }

}