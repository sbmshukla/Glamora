package com.sbmshukla.glamora.Model

import android.os.Parcel
import android.os.Parcelable

data class ItemsModel(
    val title: String="",
    val description: String="",
    val picUrl: ArrayList<String> = ArrayList(),
    val size: ArrayList<String> = ArrayList(),
    val price: Double = 0.0,
    val rating: Double = 0.0,
  //  val numberInCart: Int = 0,
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        TODO("picUrl"),
        TODO("size"),
        parcel.readDouble(),
        parcel.readDouble(),
       // parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
     //   parcel.writeInt(numberInCart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemsModel> {
        override fun createFromParcel(parcel: Parcel): ItemsModel {
            return ItemsModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemsModel?> {
            return arrayOfNulls(size)
        }
    }

}