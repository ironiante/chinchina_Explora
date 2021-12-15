package com.jirmanrodriguez.misiontic.sprint2_entrega_final.Detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jirmanrodriguez.misiontic.sprint2_entrega_final.databinding.ActivityDetalleBinding
import com.jirmanrodriguez.misiontic.sprint2_entrega_final.model.sitioItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val sitiosturisticos: sitioItem = intent.extras?.getSerializable("sitiosturisticos") as sitioItem

        with(detalleBinding){
            nameTextView.text =sitiosturisticos.nombreDelLugar
            descripcionTextView.text = sitiosturisticos.descripción
            Picasso.get().load(sitiosturisticos.urlpicture).into(haciendaImageView)
        }

    }
}