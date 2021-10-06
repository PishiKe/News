package com.pishi.news.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pishi.news.databinding.FragmentPoliticsBinding
import com.pishi.news.view.adapters.NewsAdapter
import com.pishi.news.viewmodel.PoliticsViewModel

class PoliticsFragment : Fragment() {

    private var _binding: FragmentPoliticsBinding? = null
    private lateinit var newsAdapter: NewsAdapter

    private lateinit var politicsViewModel: PoliticsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding!!.rvPolitics.layoutManager = LinearLayoutManager(requireActivity())

        newsAdapter = NewsAdapter(this)

        _binding!!.rvPolitics.adapter = newsAdapter

        politicsViewModel = ViewModelProvider(this).get(PoliticsViewModel::class.java)




    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPoliticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}