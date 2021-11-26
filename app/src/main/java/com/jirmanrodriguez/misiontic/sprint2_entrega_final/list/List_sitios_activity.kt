package com.jirmanrodriguez.misiontic.sprint2_entrega_final.list


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jirmanrodriguez.misiontic.sprint2_entrega_final.Detalle.DetalleActivity
import com.jirmanrodriguez.misiontic.sprint2_entrega_final.R
import com.jirmanrodriguez.misiontic.sprint2_entrega_final.model.sitio
import com.jirmanrodriguez.misiontic.sprint2_entrega_final.model.sitioItem

class list_sitios_activity: AppCompatActivity() {

    private lateinit var listChinchinaexplora: ArrayList<sitioItem>
    private lateinit var sitiosturisticosAdapter: sitiosAdapter
    private lateinit var sitiosturisticosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sitios)

        sitiosturisticosRecyclerView = findViewById(R.id.sitios_recycler_view)
        listChinchinaexplora = loadMockSitiosTuristicosFromJson()
        sitiosturisticosAdapter = sitiosAdapter(listChinchinaexplora, onItemClicked = {onSitioTuristicoClicked(it)})

        sitiosturisticosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosturisticosAdapter
            setHasFixedSize(false)
        }
    }
    private fun onSitioTuristicoClicked(sitio: sitioItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("sitio", sitio)
        startActivity(intent)
    }

    private fun loadMockSitiosTuristicosFromJson(): ArrayList<sitioItem> {
        val sitiosTuristicosString: String = applicationContext.assets.open("data.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val sitiosTuristicoList = gson.fromJson(sitiosTuristicosString, sitio:: class.java)
        return sitiosTuristicoList
    }

}


