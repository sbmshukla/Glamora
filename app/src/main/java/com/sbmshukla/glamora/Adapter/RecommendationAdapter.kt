package com.sbmshukla.glamora.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sbmshukla.glamora.Model.ItemsModel
import com.sbmshukla.glamora.databinding.RecommendViewholderBinding

class RecommendationAdapter(private val items:MutableList<ItemsModel>): RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>()  {
    private lateinit var context: Context

    inner class RecommendationViewHolder(val binding:RecommendViewholderBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendationAdapter.RecommendationViewHolder {
        context=parent.context
        val binding= RecommendViewholderBinding.inflate(LayoutInflater.from(context),parent,false)
        return RecommendationViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecommendationAdapter.RecommendationViewHolder,
        position: Int
    ) {
        val item=items[position]
        holder.binding.apply {
            titleText.text=item.title
            priceText.text="₹"+item.price.toString()
            rattingText.text=item.rating.toString()
            Glide.with(holder.itemView.context).load(item.picUrl[0]).apply(RequestOptions().centerCrop()).into(pic)
        }
    }

    override fun getItemCount(): Int = items.size
}