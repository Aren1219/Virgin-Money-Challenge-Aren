package com.example.virginmoneychallengearen.repository

import com.example.virginmoneychallengearen.model.people.PeopleModel
import com.example.virginmoneychallengearen.model.rooms.RoomsModel
import retrofit2.Response

interface Repository {

    suspend fun getPeople(): Response<PeopleModel>
    suspend fun getRooms(): Response<RoomsModel>

}