package com.jirmanrodriguez.misiontic.chinchinaexplora

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class sitiosturisticos_Adapter(
    private val sitiosturisticoslist: ArrayList<sitiosturisticos>
    ): RecyclerView.Adapter <sitiosturisticos_Adapter.ViewHolder>{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_chinina_explora, parent, false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitiosturisticos = sitiosturisticoslist[position]
        holder.bind(sitiosturisticos)

    }

    override fun getItemCount(): Int {

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind (sitiosturisticos: sitiosturisticos)

    }
}