package binar.academy.makeuplist.network

import binar.academy.makeuplist.model.ResponseMakeUpItem
import retrofit2.Call
import retrofit2.http.GET

interface MakeUpEndPoint {

    @GET("api/v1/products.json")
    fun getAllMakeUp() : Call<List<ResponseMakeUpItem>>
}