package com.jirmanrodriguez.misiontic.chinchinaexplora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class List_ChininaExplora_Activity : AppCompatActivity() {

    private lateinit var listChininaexplora: ArrayList<Sitiosturisticos>
    private lateinit var sitiosturisticosAdapter: sitiosturisticos_Adapter
    private lateinit var sitiosturisticosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chinina_explora)

        sitiosturisticosRecyclerView = findViewById(R.id.sitio_ryv)
        listChininaexplora = createMockSitiosturisticos()
        sitiosturisticosAdapter= sitiosturisticos_Adapter(listChininaexplora)

        sitiosturisticosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter= sitiosturisticosAdapter
            setHasFixedSize(false)
        }


    }

    private fun createMockSitiosturisticos(): ArrayList<Sitiosturisticos>{
        return arrayListOf(
            Sitiosturisticos(
                nombre = "Hacienda Guayabal",
                descripción = "Tour guiado del grano a la taza de café, ven a conocer el café más suave del mundo",
                puntuación = "5 estrellas"


            )
        )

    }
}