package com.example.note.feature_note.data.data_source.remote

import retrofit2.http.GET

interface RemoteAPI {

    @GET("test")
    suspend fun doNetworkCall()

}