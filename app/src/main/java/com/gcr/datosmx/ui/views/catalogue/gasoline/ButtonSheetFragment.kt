package com.gcr.datosmx.ui.views.catalogue.gasoline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gcr.datosmx.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottonsheet_fragment.*

class ButtonSheetFragment() : BottomSheetDialogFragment() {

    private lateinit var addres:String
    private lateinit var companyName:String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottonsheet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDireccion.text = getAddress()
        tvRazonSocial.text = getCompany()
    }

    fun setAddress(street:String) {
        addres = street
    }

    fun setCompany(company:String){
        companyName = company
    }

    private fun getAddress():String{
        return addres
    }

    private fun getCompany():String{
        return companyName
    }
}