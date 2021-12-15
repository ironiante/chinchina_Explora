package com.example.chinchinaexplora.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chinchinaexplora.databinding.FragmentListBinding
import com.example.chinchinaexplora.model.sitioItem
import com.example.chinchinaexplora.ui.main.MainActivity


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var sitiosturisticosAdapter: sitiosAdapter
    private var listChinchinaexplora: ArrayList<sitioItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate (inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

       // listViewModel.loadMockSitiosTuristicosFromJson(context?.assets?.open("data.json"))

        listViewModel.getSitioFromServer()

        listViewModel.onSitioturisticoloaded.observe(viewLifecycleOwner, {
            onSitiosturisticosLoadedSubscribe(it)
        })
        sitiosturisticosAdapter = sitiosAdapter(listChinchinaexplora!!, onItemClicked = {onSitioTuristicoClicked(it)})

        listBinding.sitiosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosturisticosAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSitiosturisticosLoadedSubscribe(result: ArrayList<sitioItem>?) {
        result?.let{ listChinchinaexplora ->
            sitiosturisticosAdapter.appendItems(listChinchinaexplora)
            
        }


    }

    private fun onSitioTuristicoClicked(sitioturistico: sitioItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitioturistico = sitioturistico))

    }


}