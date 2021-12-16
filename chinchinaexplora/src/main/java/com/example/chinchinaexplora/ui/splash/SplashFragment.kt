package com.example.chinchinaexplora.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
import com.example.chinchinaexplora.R
import com.example.chinchinaexplora.databinding.FragmentSplashBinding
import java.util.*
import kotlin.concurrent.timerTask

class SplashFragment: Fragment() {

    private lateinit var splashBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedIntanceState: Bundle?
    ): View?{

        splashBinding = FragmentSplashBinding.inflate(inflater, container,false)

        val timer = Timer()
        timer.schedule(
            timerTask {
                goToListFragment()
            },1000
        )

        return splashBinding.root
    }

    private fun goToListFragment() {
        //findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToNavigationList())

    }


}