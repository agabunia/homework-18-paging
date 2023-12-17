package com.example.homework_18_paging.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_18_paging.databinding.UserLayoutBinding

class RecyclerAdapter : PagingDataAdapter<ApiResult.User, RecyclerAdapter.UserViewHolder>(UserComparator) {

    object UserComparator : DiffUtil.ItemCallback<ApiResult.User>() {
        override fun areItemsTheSame(oldItem: ApiResult.User, newItem: ApiResult.User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ApiResult.User, newItem: ApiResult.User): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder((UserLayoutBinding.inflate(inflater, parent, false)))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    inner class UserViewHolder(private val binding: UserLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: ApiResult.User?) {
            val context = binding.root.context
            with(binding) {
                tvFirstName.text = user?.firstName
                tvLastName.text = user?.lastName
                tvEmail.text = user?.email
                Glide.with(context).load(user?.image).into(ivUserImage)
            }
        }
    }
}