package com.example.homework_18_paging.usersFragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_18_paging.BaseFragment
import com.example.homework_18_paging.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UsersFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var userAdapter: RecyclerAdapter
    private val viewModel: UsersViewModel by viewModels()

    override fun setUp() {
        setRecyclerAdapter()
        observeData()
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.flow.collectLatest { pagingData ->
                userAdapter.submitData(pagingData)
            }
        }
    }

    private fun setRecyclerAdapter() {
        userAdapter = RecyclerAdapter()
        with(binding) {
            recycler.layoutManager = LinearLayoutManager(requireContext())
            recycler.adapter = userAdapter
        }
    }

}
