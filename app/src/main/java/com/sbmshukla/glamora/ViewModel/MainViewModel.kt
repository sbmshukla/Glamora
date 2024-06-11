package com.sbmshukla.glamora.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sbmshukla.glamora.Model.SliderModel

class MainViewModel():ViewModel() {
    private val firebaseDatabase= FirebaseDatabase.getInstance()

    private val _banner:MutableLiveData<List<SliderModel>> = MutableLiveData()

    val banner: LiveData<List<SliderModel>> get() =_banner


    fun loadBanner(){
        val Ref=firebaseDatabase.getReference("Banner")
        Ref.addValueEventListener(object : ValueEventListener {
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