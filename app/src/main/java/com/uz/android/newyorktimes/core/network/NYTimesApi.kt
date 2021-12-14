package com.uz.android.newyorktimes.core.network

import com.uz.android.newyorktimes.core.model.ArticlePage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesApi {

    @GET("svc/mostpopular/v2/shared/1/facebook.json")
    fun facebookPage(@Query("api-key") apiKey: String): Call<ArticlePage>

    @GET("svc/mostpopular/v2/emailed/7.json")
    fun mostViewPage(@Query("api-key") apiKey: String): Call<ArticlePage>

    @GET("svc/mostpopular/v2/viewed/1.json")
    fun dayPage(@Query("api-key") apiKey: String): Call<ArticlePage>


}