package com.pishi.news.model.network

import com.pishi.news.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface PoliticalNewsAPI {

    @GET(Constants.POLITICS_API_ENDPOINT)

    fun getPoliticalNews(
        @Query (Constants.API_KEY) apiKey : String,
        @Query ()

    )
}