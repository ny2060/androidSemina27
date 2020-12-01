package com.example.android1

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SampleService{

    @Headers("Content-Type:application/json")
    @POST("/users/signin")
    fun postLogin(
        @Body body : SampleRequestData
    ) : Call<SampleResponseData>

}