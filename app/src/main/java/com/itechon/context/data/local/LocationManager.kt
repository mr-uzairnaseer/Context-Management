package com.itechon.context.data.local

import android.location.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object LocationManager {
    private val _currentLocation = MutableStateFlow<Location?>(null)
    val currentLocation: StateFlow<Location?> = _currentLocation

    fun updateLocation(lat: Double, lng: Double) {
        val loc = Location("mock").apply {
            latitude = lat
            longitude = lng
        }
        _currentLocation.value = loc
    }
}
