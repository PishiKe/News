package com.pishi.news.model.network

import com.pishi.news.model.entities.AllNews
import com.pishi.news.utils.Constants
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PoliticalNewsApiService {

    private val api =Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(PoliticalNewsAPI::class.java)

    fun getPoliticalNews() : Observable<AllNews.NewsList>{

        return api.getPoliticalNews(Constants.API_KEY_VALUE,
                Constants.PAGE_SIZE_VALUE,
                Constants.FORMAT_VALUE)
    }
}