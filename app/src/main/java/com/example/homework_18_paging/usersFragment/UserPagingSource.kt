package com.example.homework_18_paging.usersFragment

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework_18_paging.serice.Service

class UserPagingSource(private val service: Service): PagingSource<Int, ApiResult.User>() {
    override fun getRefreshKey(state: PagingState<Int, ApiResult.User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ApiResult.User> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = service.getUsers(nextPageNumber)

            if (response.isSuccessful) {
                val users = response.body()?.data ?: emptyList()
                LoadResult.Page(
                    data = users,
                    prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                    nextKey = nextPageNumber.plus(1)
                )
            } else {
                LoadResult.Error(Exception("Failed to fetch data"))
            }
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }
}
