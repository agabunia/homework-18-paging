package com.example.homework_18_paging.serice

import com.example.homework_18_paging.usersFragment.ApiResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): Response<ApiResult>
}
