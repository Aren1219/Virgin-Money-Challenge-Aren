package com.example.virginmoneychallengearen.model.people

import com.google.gson.annotations.SerializedName


data class PeopleModel(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<PeopleItemModel>
)