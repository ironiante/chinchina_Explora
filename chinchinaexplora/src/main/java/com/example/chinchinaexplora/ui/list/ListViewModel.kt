package com.example.chinchinaexplora.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chinchinaexplora.data.SitiosRepository
import com.example.chinchinaexplora.model.sitio
import com.example.chinchinaexplora.model.sitioItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel: ViewModel() {
    private var sitiosturisticosload: MutableLiveData<ArrayList<sitioItem>> = MutableLiveData()
    var onSitioturisticoloaded: LiveData<ArrayList<sitioItem>> = sitiosturisticosload

    private val repository = SitiosRepository()

    fun getSitioFromServer(){
        GlobalScope.launch (Dispatchers.IO ) {
            sitiosturisticosload.postValue(repository.getsitio())
        }
    }

    fun loadMockSitiosTuristicosFromJson(sitiosTuristicosString: InputStream?) {
        val sitiosTuristicosString = sitiosTuristicosString?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        sitiosturisticosload.value = gson.fromJson(sitiosTuristicosString, sitio:: class.java)

    }
}