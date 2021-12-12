package com.example.chinchinaexplora.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chinchinaexplora.R
import com.example.chinchinaexplora.model.sitioItem
import com.squareup.picasso.Picasso

class sitiosAdapter(
    private val sitiosTuristicoList: ArrayList<sitioItem>,
    private val onItemClicked: (sitioItem) -> Unit)
    :RecyclerView.Adapter<sitiosAdapter.sitiosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sitiosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_sitio_item, parent, false)
        return sitiosViewHolder(view)

    }

    override fun onBindViewHolder(holder: sitiosViewHolder, position: Int) {
        val sitiosturisticos = sitiosTuristicoList[position]
        holder.itemView.setOnClickListener { onItemClicked(sitiosTuristicoList[position]) }
        holder.bind(sitiosturisticos)

    }

    override fun getItemCount(): Int = sitiosTuristicoList.size

    fun appendItems(newItems: ArrayList<sitioItem>) {
        sitiosTuristicoList.clear()
        sitiosTuristicoList.addAll(newItems)
        notifyDataSetChanged()

    }

    class sitiosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nombreSitioTextView: TextView = itemView.findViewById(R.id.name_text_View)
        private var descripcionCortaTextView: TextView = itemView.findViewById(R.id.descripcion_text_View)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_View)

        fun bind(sitiosturisticos: sitioItem) {
            nombreSitioTextView.text = sitiosturisticos.nombreDelLugar
            descripcionCortaTextView.text = sitiosturisticos.descripción
            puntuacionTextView.text = sitiosturisticos.puntuación.toString()
            Picasso.get().load(sitiosturisticos.urlpicture).into(pictureImageView)

        }

    }
}