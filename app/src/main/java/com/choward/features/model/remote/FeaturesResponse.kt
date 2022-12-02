package com.choward.features.model.remote

import android.location.Location

data class FeaturesResponse (
    val businesses: List<FeaturesBusiness>
)

data class FeaturesBusiness(
    val id: String,
    val name: String,
    val image_url: String,
    val url: String,
    val is_closed: Boolean,
    val rating: Double,
    val display_phone: String,
    val location: DisplayLocation
)

data class DisplayLocation(
    val address1: String,
    val address2: String?,
    val address3: String?,
    val city: String,
    val zip_code: String,
    val country: String,
    val state: String,
    val display_address: List<String>,
)


