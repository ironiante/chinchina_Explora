package com.example.chinchinaexplora.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chinchinaexplora.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val guayabal = LatLng(4.95879418439515, -75.60643664188851)
        googleMap.addMarker(MarkerOptions().position(guayabal).title("Hacienda Guayabal").snippet("Chinchina, val: 4.5 "))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(guayabal, 10F))

        val sinai = LatLng(4.9540412153650095, -75.66092164525296)
        googleMap.addMarker(MarkerOptions().position(sinai).title("Hacienda El Sinai").snippet("Chinchina, val: 4.1 "))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sinai, 10F))
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