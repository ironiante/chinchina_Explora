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
import com.example.chinchinaexplora.model.sitioItem
import com.example.chinchinaexplora.ui.main.MainActivity
import com.squareup.picasso.Picasso


class detailFragment : Fragment() {

    private lateinit var sitios: sitioItem

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

        sitios =args.sitioturistico

        with(detailBinding){
            nameTextView.text =sitios.nombreDelLugar
            descripcion2TextView.text = sitios.descripcion2
            indicacionTextView.text = sitios.indicacion
            temperaturaTextView.text = sitios.temperatura
            Picasso.get().load(sitios.urlpicture).into(pictureImageView)

            mapButton.setOnClickListener {
                findNavController().navigate(detailFragmentDirections.actionDetailFragmentToMapsFragment(data = sitios))
            }
        }

    }


}