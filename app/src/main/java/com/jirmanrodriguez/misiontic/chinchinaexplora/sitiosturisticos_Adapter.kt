package com.jirmanrodriguez.misiontic.chinchinaexplora

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class sitiosturisticos_Adapter(
    private val sitiosturisticoslist: ArrayList<sitiosturisticos>
    ): RecyclerView.Adapter <sitiosturisticos_Adapter.ViewHolder>{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_chinchinaexplora_item, parent, false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitiosturisticos = sitiosturisticoslist[position]
        holder.bind(sitiosturisticos)

    }

    override fun getItemCount(): Int = sitiosturisticoslist.size

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var nombreSitioTextView: TextView = itemView.findViewById(R.id.nombre_sitio_text_view)
        private var descripcionCortaTextView: TextView = itemView.findViewById(R.id.descripcion_corta_text_view)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var haciendaGuayabalImageView: ImageView = itemView.findViewById(R.id.hacienda_guayabal_image_view)

        fun bind (sitiosturisticos: Sitiosturisticos){
            nombreSitioTextView.text=sitiosturisticos.nombre
            descripcionCortaTextView.text=sitiosturisticos.descripcion
            puntuacionTextView.text=sitiosturisticos.puntuacion

        }


    }
}