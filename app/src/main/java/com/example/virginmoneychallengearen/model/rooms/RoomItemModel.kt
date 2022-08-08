package com.example.virginmoneychallengearen.model.rooms


import com.google.gson.annotations.SerializedName

data class RoomItemModel(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("isOccupied")
    val isOccupied: Boolean,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int
)