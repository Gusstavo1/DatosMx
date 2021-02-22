package com.gcr.datosmx.data.repositories

import com.gcr.datosmx.data.localdata.ArchaeologicalZones
import com.gcr.datosmx.data.localdata.Beaches
import com.gcr.datosmx.data.localdata.Museums

class MapRepository {

    val data = ArchaeologicalZones()
    val beaches = Beaches()
    val museums = Museums()

    fun getPyramidsCoordinates() = data.getArcheologicalZones()
    fun getBeachesCoordinates() = beaches.getBeaches()
    fun getMuseumsCoordinates() = museums.getMuseums()
}