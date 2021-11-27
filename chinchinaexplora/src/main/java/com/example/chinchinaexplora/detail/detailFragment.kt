package com.example.chinchinaexplora.detail

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.chinchinaexplora.R
import com.example.chinchinaexplora.databinding.FragmentDetailBinding



class detailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: detailFragmentArgs by navArgs()

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
            descripcionTextView.text = sitiosturisticos.descripción
            com.squareup.picasso.Picasso.get().load(sitiosturisticos.urlpicture).into(pictureImageView)
        }
    }


}