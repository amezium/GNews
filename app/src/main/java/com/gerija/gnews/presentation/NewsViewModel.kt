package com.gerija.gnews.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.gerija.gnews.data.network.ApiFactory
import com.gerija.gnews.data.network.database.MyDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(application: Application): AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val db = MyDatabase.getInstance(application).newsDao()
    val getTopNews = db.getTopNews()


    fun loadData(){
        val disposable = ApiFactory.apiService.loadTopNews()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    db.insertDataBase(it.articles)
                },{
                    Log.d("MyLog", "articles: 2")
                }
            )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}