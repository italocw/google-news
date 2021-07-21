package com.example.googlenews

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class NewsRecyclerViewAdapter : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

     var data = listOf<News>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //  val item = data[position]
       // holder.titleText.text = item.title
        holder.newsImage.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount() = 25

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.title_text)
        val newsImage: ImageView = view.findViewById(R.id.news_image)
    }
}