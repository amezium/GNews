package com.gerija.gnews.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gerija.gnews.R
import io.reactivex.disposables.CompositeDisposable


class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadData()
        viewModel.getTopNews.observe(this){
           Log.d("MyLog1", "$it")
        }
     }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}