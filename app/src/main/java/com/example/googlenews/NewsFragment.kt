package com.example.googlenews

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.googlenews.databinding.FragmentNewsListBinding
import com.example.googlenews.network.NewsRequestResponse
import com.example.googlenews.network.GoogleNewsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewsListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        setNewsAdapter(binding)

        requestNews(binding)
        return binding.root
    }

    private fun requestNews(binding: FragmentNewsListBinding) {
        GoogleNewsApi.retrofitService.getTopHeadlines()
            .enqueue(object : Callback<NewsRequestResponse> {
                override fun onFailure(call: Call<NewsRequestResponse>, t: Throwable) {
                    //todo implement error message displaying  response = "Failure: " + t.message
                }

                override fun onResponse(
                    call: Call<NewsRequestResponse>,
                    requestResponse: Response<NewsRequestResponse>
                ) {
                    val newsResponse = requestResponse.body() as NewsRequestResponse
                    val adapter = binding.newsList.adapter as NewsRecyclerViewAdapter
                    adapter.data = newsResponse.articles
                    adapter.notifyDataSetChanged()

                }
            })
    }

    private fun setNewsAdapter(binding: FragmentNewsListBinding) {
        val view = binding.root

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                val adapter = NewsRecyclerViewAdapter()

                binding.newsList.adapter = adapter
            }
        }
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}