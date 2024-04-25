package com.teerapat.myapplication

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.View.BaseSavedState

//class CustomViewSavedState(superState: Parcelable?) : BaseSavedState(superState) {
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        super.writeToParcel(parcel, flags)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<CustomViewSavedState> {
//        override fun createFromParcel(parcel: Parcel): CustomViewSavedState {
//            return CustomViewSavedState(parcel)
//        }
//
//        override fun newArray(size: Int): Array<CustomViewSavedState?> {
//            return arrayOfNulls(size)
//        }
//    }
//
//}