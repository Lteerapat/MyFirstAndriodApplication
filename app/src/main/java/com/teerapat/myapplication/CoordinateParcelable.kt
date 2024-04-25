package com.teerapat.myapplication

import android.os.Parcel
import android.os.Parcelable

class CoordinateParcelable() : Parcelable {

    var x: Int = 0
    var y: Int = 0
    var z: Int = 0

    fun CoordinateParcelable() {

    }

    constructor(parcel: Parcel) : this() {
        x = parcel.readInt()
        y = parcel.readInt()
        z = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(x)
        parcel.writeInt(y)
        parcel.writeInt(z)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoordinateParcelable> {
        override fun createFromParcel(parcel: Parcel): CoordinateParcelable {
            return CoordinateParcelable(parcel)
        }

        override fun newArray(size: Int): Array<CoordinateParcelable?> {
            return arrayOfNulls(size)
        }
    }
}