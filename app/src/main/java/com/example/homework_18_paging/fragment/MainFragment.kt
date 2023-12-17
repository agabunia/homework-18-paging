package com.example.homework_18_paging.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_18_paging.BaseFragment
import com.example.homework_18_paging.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var userAdapter: RecyclerAdapter
    private val viewModel: ViewModel by viewModels()

    override fun setUp() {
        setRecyclerAdapter()
    }

    override fun setListeners() {
        //
    }

    override fun observeData() {
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
