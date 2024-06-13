package com.sbmshukla.glamora.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sbmshukla.glamora.Model.CategoryModel
import com.sbmshukla.glamora.Model.ItemsModel
import com.sbmshukla.glamora.Model.SliderModel

class MainViewModel():ViewModel() {
    private val firebaseDatabase= FirebaseDatabase.getInstance()

    private val _banner:MutableLiveData<List<SliderModel>> = MutableLiveData()
    private val _categories:MutableLiveData<MutableList<CategoryModel>> = MutableLiveData()
    private val _recommended:MutableLiveData<MutableList<ItemsModel>> = MutableLiveData()

    val banners: LiveData<List<SliderModel>> get() =_banner
    val categories: LiveData<MutableList<CategoryModel>> get() =_categories
    val recommended: LiveData<MutableList<ItemsModel>> get() =_recommended


    fun loadRecommended(){
        val ref=firebaseDatabase.getReference("Items")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list= mutableListOf<ItemsModel>()
                for (child in snapshot.children){
                    val data=child.getValue(ItemsModel::class.java)
                    data?.let { list.add(it) }
                }
                _recommended.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    fun loadCategory(){
        val ref=firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list= mutableListOf<CategoryModel>()
                for (child in snapshot.children){
                    val data=child.getValue(CategoryModel::class.java)
                    data?.let { list.add(it) }
                }
                _categories.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    fun loadBanner(){
        val ref=firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list= mutableListOf<SliderModel>()
                for (child in snapshot.children){
                    val data=child.getValue(SliderModel::class.java)
                    data?.let { list.add(it) }
                }
                _banner.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}