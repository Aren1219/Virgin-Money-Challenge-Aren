package com.example.virginmoneychallengearen.repository

import com.example.virginmoneychallengearen.api.ApiDetails
import com.example.virginmoneychallengearen.model.people.PeopleModel
import com.example.virginmoneychallengearen.model.rooms.RoomsModel
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(val apiDetails: ApiDetails): Repository {

    override suspend fun getPeople(): Response<PeopleModel> = apiDetails.getPeople()
    override suspend fun getRooms(): Response<RoomsModel>  = apiDetails.getRooms()

}