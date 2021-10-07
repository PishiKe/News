package com.pishi.news.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.pishi.news.databinding.NewsItemBinding
import com.pishi.news.model.entities.AllNews

class NewsAdapter (val fragment : Fragment) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsList : List<AllNews.NewsList> = listOf() //**

    class ViewHolder(view : NewsItemBinding) : RecyclerView.ViewHolder(view.root){

        val tvNews = view.tvNews
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding : NewsItemBinding = NewsItemBinding.inflate(LayoutInflater.from(fragment.context),
        parent, false)

        return ViewHolder (binding)
    }

    override fun onBindViewHolder(holder : ViewHolder, position: Int) {

        val news = newsList[position]

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}