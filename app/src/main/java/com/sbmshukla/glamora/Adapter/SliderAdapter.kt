package com.sbmshukla.glamora.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.sbmshukla.glamora.Model.SliderModel

class SliderAdapter(
    private var sliderItems: List<SliderModel>,
    private var viewPager2: ViewPager2
):RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    private lateinit var context: Context
    private val runnable= Runnable {
        sliderItems=sliderItems
        notifyDataSetChanged()
    }
    class SliderViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderAdapter.SliderViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SliderAdapter.SliderViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}