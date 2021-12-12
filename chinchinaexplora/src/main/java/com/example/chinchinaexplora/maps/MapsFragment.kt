package com.example.chinchinaexplora.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.chinchinaexplora.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
class MapsFragment : Fragment() {

    //private val args = MapsFragmentArgs by navArgs()
    private val callback = OnMapReadyCallback { googleMap ->

        val haciendaGuayabal =LatLng(4.9560593,-75.6108624)
        googleMap.addMarker(MarkerOptions().position(haciendaGuayabal).title("Hacienda Guayabal").snippet("Chinchiná, val: 4,5"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(haciendaGuayabal,15F))


        /*val sitios = args.data
        val sitioslugares = LatLng(sitios.latitud, sitios.longitud)
        googleMap.addMarker(
            MarkerOptions()
                .position(sitioslugares)
                .title(sitios)
                .snippet("Chinchina, val: 4.5 ")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sitioslugares, 10F))*/


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}


