package com.pishi.news.model.network

import com.pishi.news.model.entities.AllNews
import com.pishi.news.utils.Constants
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface PoliticalNewsAPI {

    @GET(Constants.API_ENDPOINT)

    fun getNews(
        @Query (Constants.API_KEY) apiKey : String) : Observable<AllNews>
}