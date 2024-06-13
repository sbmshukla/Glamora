package com.sbmshukla.glamora.View

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.sbmshukla.glamora.Adapter.CategoryAdapter
import com.sbmshukla.glamora.Adapter.RecommendationAdapter
import com.sbmshukla.glamora.Adapter.SliderAdapter
import com.sbmshukla.glamora.Model.CategoryModel
import com.sbmshukla.glamora.Model.SliderModel
import com.sbmshukla.glamora.R
import com.sbmshukla.glamora.ViewModel.MainViewModel
import com.sbmshukla.glamora.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        initBanners()
        initCategories()
        initRecommended()
    }

    private fun initBanners() {
        binding.apply {
            progressBarBanner.visibility = View.VISIBLE
            mainViewModel.banners.observe(this@MainActivity){
                banners(it)
                progressBarBanner.visibility = View.GONE
            }
            mainViewModel.loadBanner()
        }
    }

    private fun initCategories() {
        binding.apply {
            progressbarCategories.visibility = View.VISIBLE
            mainViewModel.categories.observe(this@MainActivity){
                viewCategory.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                viewCategory.adapter= CategoryAdapter(it)
                progressbarCategories.visibility = View.GONE
            }
            mainViewModel.loadCategory()
        }
    }

    private fun initRecommended() {
        binding.apply {
            progressBarRecommendations.visibility = View.VISIBLE
            mainViewModel.recommended.observe(this@MainActivity){
                viewRecommendations.layoutManager=GridLayoutManager(this@MainActivity,2)
                viewRecommendations.adapter= RecommendationAdapter(it)
                progressBarRecommendations.visibility = View.GONE
            }
            mainViewModel.loadRecommended()
        }
    }

    private fun banners(it: List<SliderModel>?) {
        binding.apply {
            viewPagerSlider.adapter= it?.let { it1 -> SliderAdapter(it1,binding.viewPagerSlider) }
            viewPagerSlider.clipToPadding=false
            viewPagerSlider.clipChildren=false
            viewPagerSlider.offscreenPageLimit=3
            viewPagerSlider.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER

            val compositePageTransformer=CompositePageTransformer().apply {
                addTransformer(MarginPageTransformer(40))
            }

            viewPagerSlider.setPageTransformer(compositePageTransformer)
            if (it!!.size>1) {
                dotIndicator.visibility=View.VISIBLE
                dotIndicator.attachTo(viewPagerSlider)
            }
        }
    }
}