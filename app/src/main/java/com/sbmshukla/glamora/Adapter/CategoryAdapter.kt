package com.sbmshukla.glamora.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sbmshukla.glamora.Model.CategoryModel
import com.sbmshukla.glamora.databinding.CategoryViewholderBinding

class CategoryAdapter(private val items:MutableList<CategoryModel>):
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private lateinit var context: Context
    inner class CategoryViewHolder(val binding:CategoryViewholderBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryViewHolder {
        context=parent.context
        val binding=CategoryViewholderBinding.inflate(LayoutInflater.from(context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val item=items[position]
        holder.binding.apply {
            titleTxt.text=item.title
            Glide.with(holder.itemView.context).load(item.picUrl).into(pic)
        }
    }

    override fun getItemCount()=items.size
}