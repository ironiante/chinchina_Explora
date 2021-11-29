package com.example.chinchinaexplora.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chinchinaexplora.R
import com.example.chinchinaexplora.databinding.FragmentListBinding
import com.example.chinchinaexplora.main.MainActivity
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
    ): View {
        listBinding = FragmentListBinding.inflate (inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listChinchinaexplora = loadMockSitiosTuristicosFromJson()
        sitiosturisticosAdapter = sitiosAdapter(listChinchinaexplora, onItemClicked = {onSitioTuristicoClicked(it)})

        listBinding.sitiosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosturisticosAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSitioTuristicoClicked(sitioturistico: sitioItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitioturistico = sitioturistico))

    }

    private fun loadMockSitiosTuristicosFromJson(): ArrayList<sitioItem> {
        val sitiosTuristicosString: String = context?.assets?.open("data.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val sitiosTuristicoList = gson.fromJson(sitiosTuristicosString, sitio:: class.java)
        return sitiosTuristicoList
    }

}