package com.pishi.news.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pishi.news.databinding.FragmentPoliticsBinding
import com.pishi.news.view.adapters.NewsAdapter
import com.pishi.news.viewmodel.PoliticsViewModel

class PoliticsFragment : Fragment() {

    private var _binding: FragmentPoliticsBinding? = null

    private lateinit var politicsViewModel: PoliticsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        politicsViewModel = ViewModelProvider(this).get(PoliticsViewModel::class.java)

        politicsViewModel.getRandomPoliticsNewsFromApi()

        politicalNewsViewModelObserver()

    }

    private fun politicalNewsViewModelObserver (){

        politicsViewModel.randomPoliticalNewsResponse.observe(viewLifecycleOwner,
            { randomPoliticalNewsResponse ->
                randomPoliticalNewsResponse?.let {
                        Log.i("Random News Response", "${randomPoliticalNewsResponse.articles[1]}")
                }
            }
        )

        politicsViewModel.randomPoliticalNewsLoadingError.observe(viewLifecycleOwner,
            {
                dataError ->
                    dataError?.let {
                        Log.e("Political News Data Error","$dataError")
                    }
            }
        )

        politicsViewModel.loadPoliticalNews.observe(viewLifecycleOwner,
            {
                loadPoliticalNews ->
                    loadPoliticalNews?.let {
                        Log.i("Political News Loading", "$loadPoliticalNews")
                    }
            })
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