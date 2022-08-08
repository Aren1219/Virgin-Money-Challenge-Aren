package com.example.virginmoneychallengearen.model.rooms

import com.google.gson.annotations.SerializedName

data class RoomsModel(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<RoomItemModel>
)