package com.jirmanrodriguez.misiontic.sprint2_entrega_final


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class list_sitios_activity: AppCompatActivity() {

    private lateinit var listChinchinaexplora: ArrayList<sitioItem>
    private lateinit var sitiosturisticosAdapter: sitiosAdapter
    private lateinit var sitiosturisticosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sitios)

        sitiosturisticosRecyclerView = findViewById(R.id.sitios_recycler_view)
        listChinchinaexplora = loadMockSitiosTuristicosFromJson()
        sitiosturisticosAdapter = sitiosAdapter(listChinchinaexplora)

        sitiosturisticosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosturisticosAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockSitiosTuristicosFromJson(): ArrayList<sitioItem> {
        val sitiosTuristicosString: String = applicationContext.assets.open("data.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val sitiosTuristicoList = gson.fromJson(sitiosTuristicosString, sitio:: class.java)
        return sitiosTuristicoList
    }

}