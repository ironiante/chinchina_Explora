package com.example.chinchinaexplora.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.chinchinaexplora.databinding.FragmentDetailBinding
import com.example.chinchinaexplora.ui.main.MainActivity
import com.example.chinchinaexplora.maps.MapsFragment


class detailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: detailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)


        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sitiosturisticos =args.sitioturistico

        with(detailBinding){
            nameTextView.text =sitiosturisticos.nombreDelLugar
            descripcion2TextView.text = sitiosturisticos.descripcion2
            indicacionTextView.text = sitiosturisticos.indicacion
            temperaturaTextView.text = sitiosturisticos.temperatura
            com.squareup.picasso.Picasso.get().load(sitiosturisticos.urlpicture).into(pictureImageView)

            mapButton.setOnClickListener {
                findNavController().navigate(detailFragmentDirections.actionDetailFragmentToMapsFragment())
            }
        }
        //val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        //mapFragment?.getMapAsync(callback)
    }


}