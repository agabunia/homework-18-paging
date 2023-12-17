package com.example.homework_18_paging.splashFragment

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.homework_18_paging.BaseFragment
import com.example.homework_18_paging.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun setUp() {
        launch()
    }

    override fun setListeners() {
        //
    }

    override fun observeData() {
        //
    }

    private fun launch() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                delay(3000)
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
            }
        }
    }

}