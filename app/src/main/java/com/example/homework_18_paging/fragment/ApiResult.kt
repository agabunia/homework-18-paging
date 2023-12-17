package com.example.homework_18_paging.fragment

import com.squareup.moshi.Json

data class ApiResult(
    @Json(name = "page")
    val page: Int,
    @Json(name = "data")
    val data: List<User>
) {
    data class User(
        @Json(name = "id")
        val id: Int,
        @Json(name = "email")
        val email: String,
        @Json(name = "first_name")
        val firstName: String,
        @Json(name = "last_name")
        val lastName: String,
        @Json(name = "avatar")
        val image: String
    )
}
