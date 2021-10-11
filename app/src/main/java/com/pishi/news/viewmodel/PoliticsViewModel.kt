package com.pishi.news.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pishi.news.model.entities.AllNews
import com.pishi.news.model.network.ServiceBuilder
import com.pishi.news.utils.Constants
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PoliticsViewModel : ViewModel() {

    private val serviceBuilder = ServiceBuilder
    private val compositeDisposable = CompositeDisposable()

    val loadPoliticalNews = MutableLiveData<Boolean>()
    val randomPoliticalNewsResponse = MutableLiveData<AllNews.NewsList>()
    val randomPoliticalNewsLoadingError =MutableLiveData<Boolean>()

    fun getRandomPoliticsNewsFromApi(){

        loadPoliticalNews.value = true

        compositeDisposable.add(
            ServiceBuilder.buildService().getNews(apiKey = Constants.API_KEY_VALUE)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<AllNews>(){
                    override fun onNext(t: AllNews) {
                        TODO("Not yet implemented")
                    }

                    override fun onError(e: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onComplete() {
                        TODO("Not yet implemented")
                    }
                })
        )
    }

}