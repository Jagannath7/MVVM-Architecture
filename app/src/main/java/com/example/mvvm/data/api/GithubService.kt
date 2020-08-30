package com.example.mvvm.data.api

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    suspend fun getUsers(): Response<JsonObject>

    @GET("search/users")
    suspend fun searchUser(@Query("q") name:String): Response<JsonObject>

}
