package com.example.googlenews

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
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
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = 25

    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.title_text)
        val newsImage: ImageView = view.findViewById(R.id.news_image)

        fun bind() {  //  val item = data[position]
            // holder.titleText.text = item.title
            newsImage.setImageResource(R.drawable.ic_launcher_background)
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