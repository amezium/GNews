package com.gerija.gnews.viewmodel



import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gerija.gnews.Component
import com.gerija.gnews.repository.GetTopNewsUseCase
import com.gerija.gnews.repository.loadDataApiInsertDbUseCase


class NewsViewModelFactory(context: Context): ViewModelProvider.Factory {

    lateinit var loadDataApiInsertDbUseCase: loadDataApiInsertDbUseCase
    lateinit var getTopNewsUseCase: GetTopNewsUseCase

    init {
        Component(context).inject(this)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return NewsViewModel(loadDataApiInsertDbUseCase, getTopNewsUseCase) as T
    }
}