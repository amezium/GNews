package com.gerija.gnews.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gerija.gnews.R
import com.gerija.gnews.model.network.dto.Articles
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsList: List<Articles>, private val content: Content)
    : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    interface Content{
        fun onclick(itemContent: Articles)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_item, parent,
            false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val item = newsList[position]
        Picasso.get().load(item.image).into(holder.imNews)
        holder.title.text = item.title
        holder.descreption.text = item.description
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

   inner class NewsHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val descreption = view.findViewById<TextView>(R.id.tvDescription)
        val imNews = view.findViewById<ImageView>(R.id.imNews)

        init {
            view.setOnClickListener {
                content.onclick(newsList[position])
            }
        }
    }
}