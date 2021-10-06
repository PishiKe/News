package com.pishi.news.model.network

import com.pishi.news.model.entities.AllNews
import com.pishi.news.utils.Constants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface PoliticalNewsAPI {

    @GET(Constants.POLITICS_API_ENDPOINT)

    fun getPoliticalNews(
        @Query (Constants.API_KEY) apiKey : String,
        @Query (Constants.PAGE_SIZE) number : Int,
        @Query (Constants.FORMAT) format : String
    ) : Observable <AllNews.NewsList>
}