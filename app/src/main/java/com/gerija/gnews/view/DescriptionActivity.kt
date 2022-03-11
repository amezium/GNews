package com.gerija.gnews.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import androidx.activity.viewModels
import com.gerija.gnews.R
import com.gerija.gnews.databinding.ActivityDescriptionBinding
import com.gerija.gnews.model.network.dto.Articles
import com.gerija.gnews.viewmodel.NewsViewModel
import com.squareup.picasso.Picasso
import retrofit2.http.Url
import java.net.URL
import java.net.URLDecoder
import android.text.Spannable
import android.content.Intent

class DescriptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityDescriptionBinding
    private val viewModel: NewsViewModel by viewModels()
    lateinit var intentArticles: Articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intentArticles = intent.getSerializableExtra("itemContent") as Articles

        getDescriptionNews()
    }

    /**
     * Получаю данные с базы данных и интента(определить какая новость)
     */
    private fun getDescriptionNews() {

        viewModel._getNews.observe(this) {
            Picasso.get().load(intentArticles.image).into(binding.imContent)
            binding.tvContent.text = intentArticles.content
            startLink()
        }
    }

    /**
     * Устанавливаю ссылку на статью и делаю ее кликабельной с открытием в браузере
     */
    private fun startLink(){
        val textLink = "<a href=>Continuation...</a>"
        binding.tvLink.text = Html.fromHtml(textLink, null, null)

        binding.tvLink.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("${intentArticles.url}"))
            startActivity(browserIntent)
        }
    }
}