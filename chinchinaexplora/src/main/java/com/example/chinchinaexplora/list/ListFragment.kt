package com.example.chinchinaexplora.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chinchinaexplora.R
import com.example.chinchinaexplora.databinding.FragmentListBinding
import com.example.chinchinaexplora.model.sitio
import com.example.chinchinaexplora.model.sitioItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listChinchinaexplora: ArrayList<sitioItem>
    private lateinit var sitiosturisticosAdapter: sitiosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate (inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listChinchinaexplora = loadMockSitiosTuristicosFromJson()
        sitiosturisticosAdapter = sitiosAdapter(listChinchinaexplora, onItemClicked = {onSitioTuristicoClicked(it)})

    }

    private fun onSitioTuristicoClicked(sitio: sitioItem) {

    }


    private fun loadMockSitiosTuristicosFromJson(): ArrayList<sitioItem> {
        val sitiosTuristicosString: String = context?.assets?.open("data.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val sitiosTuristicoList = gson.fromJson(sitiosTuristicosString, sitio:: class.java)
        return sitiosTuristicoList
    }



}