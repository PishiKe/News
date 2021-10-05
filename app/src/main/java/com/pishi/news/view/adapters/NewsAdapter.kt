package com.pishi.news.view.adapters

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.pishi.news.databinding.NewsItemBinding

class NewsAdapter (val fragment : Fragment) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view : NewsItemBinding) : RecyclerView.ViewHolder(view.root){

        val ivNews = view.ivNews
        val tvNews = view.tvNews
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}