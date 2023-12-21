package com.example.homework_18_paging.splashFragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework_18_paging.BaseFragment
import com.example.homework_18_paging.databinding.FragmentSplashBinding
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    private val viewModel: SplashViewModel by viewModels()

    override fun setUp() {
        launch()
    }

    private fun launch() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.successFlow.collect {
                when (it) {
                    is NavigationEvents.NavigateToUsersFragment -> navigateToUsersFragment()
                }
            }
        }
    }

    private fun navigateToUsersFragment() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
    }

}