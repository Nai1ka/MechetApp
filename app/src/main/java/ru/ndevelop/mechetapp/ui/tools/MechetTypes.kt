package ru.ndevelop.mechetapp.ui.tools

import com.google.android.gms.maps.model.LatLng

enum class MechetType(val mechetName:String, val coordinates:LatLng,val year:String){
    APANAYEVSAKYA("Апанаевская мечеть",LatLng(55.777917, 49.1172183),"13423"),
    KUL_SHARIF("Кул-Шариф",LatLng(55.7983713, 49.1030479), "45345")
}
