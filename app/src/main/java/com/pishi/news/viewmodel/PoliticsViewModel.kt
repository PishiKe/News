package com.pishi.news.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pishi.news.model.entities.AllNews
import com.pishi.news.model.network.PoliticalNewsApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PoliticsViewModel : ViewModel() {

    private val politicalNewsApiService = PoliticalNewsApiService()
    private val compositeDisposable = CompositeDisposable()

    val loadPoliticalNews = MutableLiveData<Boolean>()
    val randomPoliticalNewsResponse = MutableLiveData<AllNews.NewsList>()
    val randomPoliticalNewsLoadingError =MutableLiveData<Boolean>()

    fun getRandomPoliticsNewsFromApi(){

        loadPoliticalNews.value = true

        compositeDisposable.add(
            politicalNewsApiService.getPoliticalNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableObserver <AllNews.NewsList>(){
                    override fun onNext(value: AllNews.NewsList) {
                        loadPoliticalNews.value =false
                        randomPoliticalNewsResponse.value = value
                        randomPoliticalNewsLoadingError.value = false
                    }

                    override fun onError(e: Throwable) {
                        loadPoliticalNews.value = false
                        randomPoliticalNewsLoadingError.value = true
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                        Log.i("Political News Load","Success!!")
                    }

                })
        )
    }

}