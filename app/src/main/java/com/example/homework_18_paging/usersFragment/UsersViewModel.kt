package com.example.homework_18_paging.usersFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.homework_18_paging.network.NetworkModel

class UsersViewModel : ViewModel() {
    private val userPagingSource = UserPagingSource(NetworkModel.get())

    val flow = Pager(PagingConfig(pageSize = 20)) {
        userPagingSource
    }.flow.cachedIn(viewModelScope)

}
