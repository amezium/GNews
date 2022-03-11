package com.gerija.gnews.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gerija.gnews.databinding.ActivityMainBinding
import com.gerija.gnews.model.database.NewsDatabase
import com.gerija.gnews.model.network.dto.Articles
import com.gerija.gnews.viewmodel.NewsViewModel
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity(), NewsAdapter.Content {

    private val viewModel: NewsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel._getNews.observe(this) {
            val adapter = NewsAdapter(it, this)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onclick(itemContent: Articles) {
        val i = Intent(this, DescriptionActivity::class.java)
        i.putExtra("itemContent", itemContent)
        startActivity(i)
    }
}