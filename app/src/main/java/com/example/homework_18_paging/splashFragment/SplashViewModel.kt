package com.example.homework_18_paging.splashFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _successFlow = MutableSharedFlow<NavigationEvents>()
    val successFlow: SharedFlow<NavigationEvents> = _successFlow

    init {
        navigateToUsersFragment()
    }

    private fun navigateToUsersFragment() {
        viewModelScope.launch {
            delay(3000)
            _successFlow.emit(NavigationEvents.NavigateToUsersFragment)
        }
    }

}
