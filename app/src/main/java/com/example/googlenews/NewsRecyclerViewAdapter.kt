package com.example.googlenews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.googlenews.network.News

class NewsRecyclerViewAdapter : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    var data = listOf<News>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.title_text)
        val newsImage: ImageView = view.findViewById(R.id.news_image)

        fun bind(news: News) {
            titleText.text = news.title
            setImageFromWeb(news)
        }

        private fun setImageFromWeb(news: News) {
            Glide.with(newsImage.context)
                .load((news.urlToImage))
                .into(newsImage)
        }

        companion object {
            fun from(
                parent: ViewGroup
            ): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.news_item, parent, false)
                return ViewHolder(view)
            }
        }
    }
}