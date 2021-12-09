package com.example.chinchinaexplora.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chinchinaexplora.model.sitio
import com.example.chinchinaexplora.model.sitioItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel: ViewModel() {
    private var sitiosturisticosload: MutableLiveData<ArrayList<sitioItem>> = MutableLiveData()
    var onSitioturisticoloaded: LiveData<ArrayList<sitioItem>> = sitiosturisticosload

    fun loadMockSitiosTuristicosFromJson(sitiosTuristicosString: InputStream?) {
        val sitiosTuristicosString = sitiosTuristicosString?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        sitiosturisticosload.value = gson.fromJson(sitiosTuristicosString, sitio:: class.java)

    }
}