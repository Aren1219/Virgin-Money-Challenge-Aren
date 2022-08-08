package com.example.virginmoneychallengearen.api

import com.example.virginmoneychallengearen.model.people.PeopleModel
import com.example.virginmoneychallengearen.model.rooms.RoomsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetails {

    @GET("people")
    suspend fun getPeople():Response<PeopleModel>

    @GET("rooms")
    suspend fun getRooms():Response<RoomsModel>

}